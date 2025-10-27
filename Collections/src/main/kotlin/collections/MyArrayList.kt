package collections

class MyArrayList<T> : MyMutableList<T> {

    private var elements = arrayOfNulls<Any>(INITIAL_CAPACITY)
    private var modCount = 0

    override var size: Int = 0
        private set

    private fun growIfNeeded() {
        if (elements.size == size) {
            val newArray = arrayOfNulls<Any>(elements.size * 2)
            System.arraycopy(elements, 0, newArray, 0, elements.size)
            elements = newArray
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
        modCount++
        growIfNeeded()
        elements[size] = element
        size++
        return true
    }

    override fun plus(element: T) {
        add(element)
    }

    override fun add(index: Int, element: T) {
        modCount++
        checkIndexForAdding(index)
        growIfNeeded()
        System.arraycopy(elements, index, elements, index+1, size-index)
        elements[index] = element
        size++
    }

    override fun get(index: Int): T {
        checkIndex(index)
        return elements[index] as T
    }

    override fun removeAt(index: Int) {
        modCount++
        checkIndex(index)
        System.arraycopy(elements, index+1, elements, index, size-index-1)
        size--
        elements[size] = null
    }

    override fun remove(element: T) {
        modCount++
        for(i in 0 until size) {
            if (element == elements[i]) {
                removeAt(i)
                return
            }
        }
    }

    override fun minus(element: T) {
        remove(element)
    }

    override fun clear() {
        modCount++
        elements = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(element: T): Boolean {
        for(i in 0 until size) {
            if (element == elements[i])
                return true
        }
        return false
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            private var nextIndex = 0
            private var currentModCount = modCount

            override fun hasNext(): Boolean {
                return nextIndex < size
            }

            override fun next(): T {
                if (currentModCount != modCount) throw ConcurrentModificationException()
                return elements[nextIndex++] as T
            }
        }
    }


    companion object {
        private const val INITIAL_CAPACITY = 10
    }
}