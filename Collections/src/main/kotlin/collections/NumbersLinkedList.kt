package collections

class NumbersLinkedList : NumbersMutableList {

    private var first: Node? = null
    private var last: Node? = null
    override var size: Int = 0
        private set

    private fun getNode(index: Int): Node {
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
    override fun add(number: Int) {
        val prevLast = last
        last = Node(number, null, prevLast)
        if (prevLast == null) {
            first = last
        } else {
            prevLast.next = last
        }
        size++
    }

    override fun add(index: Int, number: Int) {
        checkIndexForAdding(index)
        if (index == size) {
            add(number)
            return
        }
        if (index == 0) {
            val node = Node(number, first, null)
            first?.prev = node
            first = node
            size++
            return
        }
        val before = getNode(index - 1)
        val after = before.next
        val newNode = Node(number, after, before)
        before.next = newNode
        after?.prev = newNode
        size++
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun get(index: Int): Int {
        checkIndex(index)
        return getNode(index).item
    }

    private fun unlink(node: Node) {
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
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        val node = getNode(index)
        unlink(node)
    }

    override fun remove(number: Int) {
        var node = first
        repeat(size) {
            if (node?.item == number) {
                unlink(node)
                return
            } else {
                node = node?.next
            }
        }
    }

    override fun minus(number: Int) {
        remove(number)
    }

    override fun clear() {
            first = null
            last = null
            size = 0
    }

    override fun contains(number: Int): Boolean {
        var node = first
        repeat(size) {
            if (node!!.item == number) {
                return true
            } else {
                node = node.next
            }
        }
        return false
    }

    class Node (
        val item: Int,
        var next: Node? = null,
        var prev: Node? = null
    )
}