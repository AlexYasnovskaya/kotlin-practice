package collections

import kotlin.math.abs

class NumbersHashSet<T> : NumbersMutableSet<T> {
    override var size: Int = 0
        private set

    private var elements = arrayOfNulls<Node<T>>(INITIAL_CAPACITY)

    private fun getElementPosition(number: T, arraySize: Int): Int {
        return abs(number.hashCode() % arraySize)
    }

    private fun increaseArray() {
        val newArray = arrayOfNulls<Node<T>>(elements.size * 2)
        for (node in elements) {
            var currentElement = node
            while (currentElement != null) {
                add(currentElement.item, newArray)
                currentElement = currentElement.next
            }
        }
        elements = newArray
    }

    override fun add(element: T): Boolean {
        if (size >= elements.size * LOAD_FACTORY) {
            increaseArray()
        }
        return add(element, elements).also { added ->
            if (added) size++
        }
    }

    private fun add(element: T, array: Array<Node<T>?>): Boolean {
        val node = Node(element, null)
        val position = getElementPosition(element, array.size)
        var existedElement = array[position]
        if (existedElement == null) {
            array[position] = node
            return true
        } else {
            while (true) {
                if (existedElement?.item == element) return false
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

    override fun remove(element: T) {
        val position = getElementPosition(element, elements.size)
        val existedElement = elements[position] ?: return
        if (existedElement.item == element) {
            elements[position] = existedElement.next
            size--
            return
        }

        var before: Node<T>? = existedElement
        while (before?.next != null) {
            val removingElement = before.next
            if (removingElement?.item == element) {
                before.next = removingElement.next
                size--
                return
            } else {
                before = before.next
            }
        }
    }

    override fun clear() {
        elements = arrayOfNulls<Node<T>>(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(element: T): Boolean {
        val position = getElementPosition(element, elements.size)
        var existedElement = elements[position]
        while (existedElement != null) {
            if (existedElement.item == element) return true
            else {
                existedElement = existedElement.next
            }
        }
        return false
    }

    data class Node<T> (
        val item: T,
        var next: Node<T>? = null
    )

    companion object {
        private const val INITIAL_CAPACITY = 16
        private const val LOAD_FACTORY = 0.75
    }
}