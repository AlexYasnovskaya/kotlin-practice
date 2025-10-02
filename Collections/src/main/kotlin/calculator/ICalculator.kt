package calculator

interface ICalculator {
    fun sum(a: Int, b: Int): Int
    fun division(a: Int, b: Int): Double
    fun multiplication(a: Int, b: Int): Int
    fun subtraction(a: Int, b: Int): Int
}