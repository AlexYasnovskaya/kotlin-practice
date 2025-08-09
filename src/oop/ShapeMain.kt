package oop

fun main() {
    val rectangle: Shape = Shape(3, 5)
    rectangle.draw()

    println("new shape")
    val square: Shape = Shape(5)
    square.draw()
}