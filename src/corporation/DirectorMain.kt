package corporation

fun main() {
    val assistant: Worker = Assistant("Helen")
    val consultant: Worker = Consultant("Mark", 24)
    val director: Director = Director("Joe", 35)
    val employees = listOf<Worker>(director, assistant, consultant)

    for (employee in employees) {
        employee.work()
    }
}