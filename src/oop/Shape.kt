package oop

class Shape(
    var height: Int,
    var width: Int
) {

//    constructor(size: Int): this(size, size) // вызов вторичного конструктора

//    val test = 0
//        private set // запрещаем присваивать переменной что-либо извне, только работа внутри


    val area: Int
        get() = width * height

    fun draw() {
        repeat(height) {
            repeat(width) {
                print(" * ")
            }
            print("\n")
        }
    }
}