package corporation

fun main() {
    val assistant: Worker = Assistant("Helen", 25, 1)
    val consultant: Worker = Consultant("Mark", 24, 2)
    val accountant: Accountant = Accountant("Lisa", 20, 3)
    val director: Director = Director("Joe", 35, 4)
    val employees = listOf<Worker>(director, assistant, consultant, accountant)

    for (employee in employees) {
        employee.work()
    }
}