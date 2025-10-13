package collections

class NumbersArrayList : NumbersMutableList {

    private var numbers = arrayOfNulls<Int>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    private fun growIfNeeded() {
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            System.arraycopy(numbers, 0, newArray, 0, numbers.size)
            numbers = newArray
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
        growIfNeeded()
        numbers[size] = number
        size++
    }

    override fun plus(number: Int) {
        add(number)
    }

    override fun add(index: Int, number: Int) {
        checkIndexForAdding(index)
        growIfNeeded()
        System.arraycopy(numbers, index, numbers, index+1, size-index)
        numbers[index] = number
        size++
    }

    override fun get(index: Int): Int {
        checkIndex(index)
        return numbers[index]!!
    }

    override fun removeAt(index: Int) {
        checkIndex(index)
        System.arraycopy(numbers, index+1, numbers, index, size-index-1)
        size--
        numbers[size] = null
    }

    override fun remove(number: Int) {
        for(i in 0 until size) {
            if (i == numbers[i]) {
                removeAt(i)
                return
            }
        }
    }

    override fun minus(number: Int) {
        remove(number)
    }

    override fun clear() {
        numbers = arrayOfNulls(INITIAL_CAPACITY)
        size = 0
    }

    override fun contains(number: Int): Boolean {
        for(i in 0 until size) {
            if (number == numbers[i])
                return true
        }
        return false
    }

    companion object {
        private const val INITIAL_CAPACITY = 10
    }
}