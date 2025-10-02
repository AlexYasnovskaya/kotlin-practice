package calculator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `when 5 Add To 10 Then Result 15`() {
        val result = calculator.sum(10, 5)
        val expected = 15

        assertEquals(expected, result)
    }

    @Test
    fun `when 100 add to 50 then result 150`() {
        val result = calculator.sum(100, 50)
        val expected = 150

        assertEquals(expected, result)
    }

    @Test
    fun `float and double`() {
        var number = 0.0
        repeat(100) {
            number += 0.01
        }
        val expected = 1.0

        assertEquals(expected, number, 0.01)
    }

    @Test
    fun `when multiplication 2 and 4 then result 8`() {
        val result = calculator.multiplication(2, 4)
        val expected = 8

        assertEquals(expected,result)
    }

    @Test
    fun `when multiplication 0 and 4 then result 0`() {
        val result = calculator.multiplication(0, 4)
        val expected = 0

        assertEquals(expected,result)
    }

    @Test
    fun `when substraction 10 and 5 then result 5`() {
        val result = calculator.subtraction(10, 5)
        val expected = 5

        assertEquals(expected,result)
    }

    @Test
    fun `when substraction 10 and 4 then result 6`() {
        val result = calculator.subtraction(10, 4)
        val expected = 6

        assertEquals(expected,result)
    }

    @Test
    fun `when 4 divide 2 than result 2`() {
        val result = calculator.division(4, 2)
        val expected = 2.0

        assertEquals(expected, result)
    }
}