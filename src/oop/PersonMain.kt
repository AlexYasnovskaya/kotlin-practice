package oop

fun main() {
    println("Ur name?")
    val name = readln()
    println("ur first name?")
    val lastName = readln()
    println("Age?")
    val age = readln().toInt()
    val person = Person(name, 170, 50, lastName)
    person.age = age
    println(person.fullName)
}