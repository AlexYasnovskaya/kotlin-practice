package oop

fun main() {
    val john: Person = Person()
    println("Ur name?")
    john.name = readln()
    println("Age?")
    john.age = readln().toInt()
    println("Name: ${john.name}\nAge: ${john.age}")

    john.sayHello()
    john.run()
}