package collections

class NumbersArrayList : NumbersMutableList {

    private var numbers = arrayOfNulls<Int>(INITIAL_CAPACITY)

    override var size: Int = 0
        private set

    private fun growIfNeeded() {
        if (numbers.size == size) {
            val newArray = arrayOfNulls<Int>(numbers.size * 2)
            for (index in numbers.indices) {
                newArray[index] = numbers[index]
            }
            numbers = newArray
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
        growIfNeeded()
        for (i in size downTo index + 1) {
            numbers[i] = numbers[i-1]
        }
        numbers[index] = number
        size++
    }

    override fun get(index: Int): Int {
        return numbers[index]!!
    }

    override fun removeAt(index: Int) {
        for (i in index until size - 1) {
            numbers[i] = numbers[i+1]
        }
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