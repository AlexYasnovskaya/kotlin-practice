package oop

class Person {
    var name: String = ""
    var age: Int = 0
        set(value) {
            if (value > field) {
                field = value
            } else {
                println("the new age must be than the old one")
            }
        }
        get() {
            println("its indecent to ask a person his age")
            return age
        }

    fun sayHello() {
        println("Hello!")
    }

    fun run() {
        repeat(10) {
            print("Бегу")
        }
    }
}