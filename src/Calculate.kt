fun main() {
    val expression = readln().split(" ")
    val firstNum = expression[0].toInt()
    val secondNum = expression[2].toInt()
    val sign = expression[1]

    println(
        when(sign) {
            "+" -> firstNum + secondNum
            "-" -> firstNum - secondNum
            "/" -> firstNum / secondNum
            "*" -> firstNum * secondNum
            else -> "Error"
        }
    )

}