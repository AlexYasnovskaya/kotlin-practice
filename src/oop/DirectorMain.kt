package oop

fun main() {
    val assistant: Assistant = Assistant("Helen")
    val consultant: Consultant = Consultant("Mark", 24)
    val director: Director = Director("Joe", 35)
    director.takeCoffee(assistant)
    director.workConsultant(consultant)
}