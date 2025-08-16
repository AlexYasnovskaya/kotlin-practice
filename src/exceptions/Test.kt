package exceptions

fun main() {
//    try {
//        val a = readln().toInt()
//        val b = readln().toInt()
//
//        println(a / b)
//    } catch (error: ArithmeticException) {
//        println("u cant divide by zero")
//    } catch (error: NumberFormatException) {
//        println("wrong input")
//    } catch (error: Throwable) {
//        println("common error")
//    }

    try {
        val list = listOf<Int>(0, 1, 2)

        println(list[-1])
    } catch (error: IndexOutOfBoundsException) {
        println("wrong index")
    }
}