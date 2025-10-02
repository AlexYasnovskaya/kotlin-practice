package calculator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("calculatorSources")
    fun `when 5 Add To 10 Then Result 15`(calculator: ICalculator) {
        val result = calculator.sum(10, 5)
        val expected = 15

        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSources")
    fun `when 100 add to 50 then result 150`(calculator: ICalculator) {
        val result = calculator.sum(100, 50)
        val expected = 150

        assertEquals(expected, result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSources")
    fun `when multiplication 2 and 4 then result 8`(calculator: ICalculator) {
        val result = calculator.multiplication(2, 4)
        val expected = 8

        assertEquals(expected,result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSources")
    fun `when multiplication 0 and 4 then result 0`(calculator: ICalculator) {
        val result = calculator.multiplication(0, 4)
        val expected = 0

        assertEquals(expected,result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSources")
    fun `when substraction 10 and 5 then result 5`(calculator: ICalculator) {
        val result = calculator.subtraction(10, 5)
        val expected = 5

        assertEquals(expected,result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSources")
    fun `when substraction 10 and 4 then result 6`(calculator: ICalculator) {
        val result = calculator.subtraction(10, 4)
        val expected = 6

        assertEquals(expected,result)
    }

    @ParameterizedTest
    @MethodSource("calculatorSources")
    fun `when 4 divide 2 than result 2`(calculator: ICalculator) {
        val result = calculator.division(4, 2)
        val expected = 2.0

        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        fun calculatorSources() = listOf(SimpleCalculator(), LoggingCalculator())
    }
}