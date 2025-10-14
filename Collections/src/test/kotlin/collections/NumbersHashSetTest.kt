package collections

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NumbersHashSetTest {
    private val elements = NumbersHashSet<Int>()

    @Test
    fun `when added 100 elements then size 100` () {
        repeat(100) {
            elements.add(it)
        }
        assertEquals(100, elements.size)
    }

    @Test
    fun `when added 10 similar elements then size 1`() {
        repeat(10) {
            elements.add(1)
        }
        assertEquals(1, elements.size)
    }

    @Test
    fun `when adding is succeed then method return true`() {
        assertTrue { elements.add(1) }
    }

    @Test
    fun `when adding is failed then method return true`() {
        elements.add(0)
        assertFalse { elements.add(0) }
    }

    @Test
    fun `when element contains in collection then return true`() {
        repeat(10) {
            elements.add(it)
        }
        assertTrue { elements.contains(3) }
    }

    @Test
    fun `when element doesnt contains in collection then return true`() {
        repeat(10) {
            elements.add(it)
        }
        assertFalse { elements.contains(11) }
    }

    @Test
    fun `when element removed then size decreased`() {
        repeat(10) {
            elements.add(it)
        }
        elements.remove(2)
        assertEquals(9, elements.size)
    }

    @Test
    fun `when element removed then method contains return false`() {
        repeat(10) {
            elements.add(it)
        }
        elements.remove(2)
        assertFalse { elements.contains(2) }
    }

    @Test
    fun `when collections is cleared then size 0`() {
        repeat(10) {
            elements.add(it)
        }
        elements.clear()
        assertEquals(0, elements.size)
    }

    @Test
    fun `when collections is cleared then all elements is absent`() {
        repeat(10) {
            elements.add(it)
        }
        elements.clear()
        repeat(10) {
            assertFalse { elements.contains(it) }
        }
    }
}