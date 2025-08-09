package base

fun main() {
    val range = 0..1000 step 2

    println("Write a number")
    val userNum = readln().toInt()

    if (userNum in range) println("Число входит в диапозон")
    else println("Число не входит в диапозон")
}