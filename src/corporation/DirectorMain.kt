package corporation

fun main() {
    val assistant: Worker = Assistant("Helen")
    val consultant: Worker = Consultant("Mark", 24)
    val director: Worker = Director("Joe", 35)
    (director as Director).takeCoffee(assistant as Assistant)
    director.workConsultant((consultant as Consultant))
}