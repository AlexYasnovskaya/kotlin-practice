package collections

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NumbersMutableListTest {

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when add 1 element then size is 1`(list: NumbersMutableList) {
        list.add(0)
        assertEquals(1, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when element added to first position then it is in first position`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.add(0, 1000)
        assertEquals(1000, list.get(0))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when element added to last position then it is in last position`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        list.add(100, 1000)
        assertEquals(1000, list.get(100))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when add 10 element then size is 10`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertEquals(10, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when add 100 element then size is 100`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        assertEquals(100, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when get 5 element from collection then result is correct`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertEquals(5, list.get(5))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when get 50 element from collection then result is correct`(list: NumbersMutableList) {
        repeat(100) {
            list.add(it)
        }
        assertEquals(50, list.get(50))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when element removed then size decreased`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        list.removeAt(4)
        assertEquals(9, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when 4th element removed then next value at this position`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        list.removeAt(4)
        assertEquals(5, list.get(4))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when value 4 removed then next value at this position`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        list.remove(4)
        assertEquals(5, list.get(4))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when list is cleared then size is 0`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        list.clear()
        assertEquals(0, list.size)
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when list contains element then method return true`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertTrue(list.contains(4))
    }

    @ParameterizedTest
    @MethodSource("mutableListSource")
    fun `when list doesnt contains element then method return false`(list: NumbersMutableList) {
        repeat(10) {
            list.add(it)
        }
        assertFalse( list.contains(20))
    }

    companion object {
        @JvmStatic
        fun mutableListSource() = listOf(NumbersArrayList())
    }

}