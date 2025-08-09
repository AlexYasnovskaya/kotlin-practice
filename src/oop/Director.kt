package oop

class Director(
    val name: String,
    val age: Int
) {

    fun takeCoffee(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()
        println("thanks, ${assistant.name}! $drinkName so tasty")
    }

    fun workConsultant(consultant: Consultant) {
        val count = consultant.serveClients()
        println("${consultant.name} completed servicing $count clients")
    }
}