package collections

class NumbersLinkedList : NumbersMutableList {

    private var first: Node? = null
    private var last: Node? = null
    override var size: Int = 0
        private set

    private fun getNode(index: Int): Node {
        if (index == 0) return first!!
        if (index == size-1) return last!!

        var node = first
        repeat(index) {
            node = node?.next
        }
        return node!!
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
        if (size == 0) {
            val node = Node(number)
            first = node
            last = node
            size++
            return
        }
        val newNode = Node(number)
        last?.next = newNode
        last = newNode
        size++
    }

    override fun add(index: Int, number: Int) {
        checkIndexForAdding(index)
        if (index == size) {
            add(number)
            return
        }
        if (index == 0) {
            val node = Node(number)
            node.next = first
            first = node
            size++
            return
        }
        val before = getNode(index - 1)
        val after = before.next
        val newNode = Node(number, after)
        before.next = newNode
        size++
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun get(index: Int): Int {
        checkIndex(index)
        return getNode(index).item
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        if (index == 0 && size == 1) {
            clear()
        }
        if (index == 0) {
            first = first?.next
            size--
        }
        val before = getNode(index - 1)
        val after = before.next?.next
        before.next = after
        if (after?.next == null) {
            last = before
        }
        size--
    }

    override fun remove(number: Int) {
        if (first?.item == number) {
            removeAt(0)
            return
        }
        var before = first
        repeat(size) {
            val node = before?.next
            if (node?.item == number) {
                val after = node.next
                before.next = after
                if (after == null) {
                    last = before
                    size--
                    return
                }
            } else {
                before = before?.next
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
        var next: Node? = null
    )
}