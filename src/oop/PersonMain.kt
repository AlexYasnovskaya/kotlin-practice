package oop

fun main() {
    val person1 = Person("Alex", 170, 54, "Snow")
    val person2 = Person("Alex", 170, 54, "Snow")
    val person3 = Person("Mari", 156, 45, "Richter")
    val setList = mutableSetOf<Person>(person1, person2, person3)

    for (person in setList) {
        println(person)
    }
}