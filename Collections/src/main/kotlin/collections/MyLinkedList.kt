package collections

class MyLinkedList<T> : MyMutableList<T> {

    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var modCount = 0
    override var size: Int = 0
        private set

    private fun getNode(index: Int): Node<T> {
        if (index == 0) return first!!
        if (index == size-1) return last!!

        if (index < size / 2) {
            var node = first
            repeat(index) {
                node = node?.next
            }
            return node!!
        } else {
            var node = last
            repeat(size - index - 1) {
                node = node?.prev
            }
            return node!!
        }
    }

    private fun checkIndex(index: Int) {
        if (index !in 0..<size) {
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
    }

    private fun checkIndexForAdding(index: Int) {
        if (index !in 0..size) {
            throw IndexOutOfBoundsException("index: $index, size: $size")
        }
    }
    override fun add(element: T): Boolean {
        val prevLast = last
        last = Node(element, null, prevLast)
        if (prevLast == null) {
            first = last
        } else {
            prevLast.next = last
        }
        size++
        modCount++
        return true
    }

    override fun add(index: Int, element: T) {
        checkIndexForAdding(index)
        if (index == size) {
            add(element)
            return
        }
        if (index == 0) {
            val node = Node(element, first, null)
            first?.prev = node
            first = node
            size++
            return
        }
        val before = getNode(index - 1)
        val after = before.next
        val newNode = Node(element, after, before)
        before.next = newNode
        after?.prev = newNode
        size++
        modCount++
    }

    override fun plus(element: T) {
        add(element)
    }

    override fun get(index: Int): T {
        checkIndex(index)
        return getNode(index).item
    }

    private fun unlink(node: Node<T>) {
        val before = node.next
        val after = node.prev
        before?.next = after
        after?.prev = before
        if (after == null) {
            last = before
        }
        if (before == null) {
            first = after
        }
        size--
        modCount++
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        val node = getNode(index)
        unlink(node)
    }

    override fun remove(element: T) {
        var node = first
        repeat(size) {
            if (node?.item == element) {
                unlink(node)
                return
            } else {
                node = node?.next
            }
        }
    }

    override fun minus(element: T) {
        remove(element)
    }

    override fun clear() {
            first = null
            last = null
            size = 0
            modCount++
    }

    override fun contains(element: T): Boolean {
        var node = first
        repeat(size) {
            if (node!!.item == element) {
                return true
            } else {
                node = node.next
            }
        }
        return false
    }

    override fun iterator(): MutableIterator<T> {
        return object : MutableIterator<T> {
            private var nextNode = first
            private var currentModCount = modCount

            override fun hasNext(): Boolean {
                return nextNode != null
            }

            override fun next(): T {
                if (currentModCount != modCount) throw ConcurrentModificationException()
                return nextNode?.item!!.also {
                    nextNode = nextNode?.next
                }
            }

            override fun remove() {
                TODO("Not yet implemented")
            }
        }
    }

    class Node<T> (
        val item: T,
        var next: Node<T>? = null,
        var prev: Node<T>? = null
    )
}