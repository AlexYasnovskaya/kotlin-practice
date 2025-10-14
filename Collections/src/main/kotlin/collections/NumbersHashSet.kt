package collections

import kotlin.math.abs

class NumbersHashSet : NumbersMutableSet {
    override var size: Int = 0
        private set

    private var elements = arrayOfNulls<Node>(INITIAL_CAPACITY)

    private fun getElementPosition(number: Int, arraySize: Int): Int {
        return abs(number % arraySize)
    }

    private fun increaseArray() {
        val newArray = arrayOfNulls<Node>(elements.size * 2)
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) {
                add(currentElement.item, newArray)
                currentElement = currentElement.next
            }
        }
        elements = newArray
    }

    override fun add(number: Int): Boolean {
        if (size >= elements.size * LOAD_FACTORY) {
            increaseArray()
        }
        return add(number, elements).also { added ->
            if (added) size++
        }
    }

    private fun add(number: Int, array: Array<Node?>): Boolean {
        val node = Node(number, null)
        val position = getElementPosition(number, array.size)
        var existedElement = array[position]
        if (existedElement == null) {
            array[position] = node
            return true
        } else {
            while (true) {
                if (existedElement?.item == number) return false
                else {
                    if (existedElement?.next == null) {
                        existedElement?.next = node
                        size++
                        return true
                    } else {
                        existedElement = existedElement.next
                    }
                }
            }
        }
    }

    override fun remove(number: Int) {
        val position = getElementPosition(number, elements.size)
        var element = elements[position] ?: return
        if (element.item == number) {
            elements[position] = element.next
            size--
            return
        }

        var before: Node? = element
        while (before?.next != null) {
            val removingElement = before.next
            if (removingElement?.item == number) {
                before.next = removingElement.next
                size--
                return
            } else {
                before = before.next
            }
        }
    }

    override fun clear() {
        elements = arrayOfNulls<Node>(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(number: Int): Boolean {
        val position = getElementPosition(number, elements.size)
        var element = elements[position]
        while (element != null) {
            if (element.item == number) return true
            else {
                element = element.next
            }
        }
        return false
    }

    data class Node (
        val item: Int,
        var next: Node? = null
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTORY = 0.75
    }
}