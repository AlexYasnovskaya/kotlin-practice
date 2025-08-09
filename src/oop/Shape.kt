package oop

class Shape {
    val height: Int
    val width: Int

    constructor(height: Int, width: Int) {
        this.height = height
        this.width = width
    }

    constructor(size: Int) {
        this.height = size
        this.width = size
    }

//    constructor(size: Int): this(size, size) вызов другого конструктора

    fun draw() {
        repeat(height) {
            repeat(width) {
                print(" * ")
            }
            print("\n")
        }
    }
}