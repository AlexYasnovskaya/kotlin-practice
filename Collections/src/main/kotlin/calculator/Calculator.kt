package calculator

class Calculator {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun multiplication(a: Int, b: Int): Int {
        return a * b
    }

    fun subtraction(a: Int, b: Int): Int {
        return a - b
    }

    fun division(a: Int, b: Int): Double {
        if (b == 0) throw IllegalArgumentException("u cant divide by zero")
        return a.toDouble() / b.toDouble()
    }
}