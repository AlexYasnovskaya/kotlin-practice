package corporation

fun main() {
    val accountant: Accountant = Accountant("Lisa", 20, 3)
    val employees = accountant.loadAllEmployees()

    for (employee in employees) {
        if (employee is Cleaner) {
            employee.clean()
        }
        if (employee is Supplier) {
            employee.buyingThings()
        }
    }
}