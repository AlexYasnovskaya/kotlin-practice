package oop

class Shape(
    val height: Int,
    val width: Int
) {

    constructor(size: Int): this(size, size) // вызов вторичного конструктора

    fun draw() {
        repeat(height) {
            repeat(width) {
                print(" * ")
            }
            print("\n")
        }
    }
}