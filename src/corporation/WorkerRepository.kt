package corporation

import java.io.File

object WorkerRepository {
    private val fileEmployees = File("employees.txt")
    private val _employees = loadAllEmployees()
    val employees
        get() = _employees.toList()

    fun registerNewEmployee(employee: Worker) {
        _employees.add(employee)
    }

    fun saveChanges() {
        var content = StringBuilder()
        for (employee in _employees) {
            content.append("${employee.id}%${employee.name}%${employee.age}%${employee.getSalary()}%${employee.workerType}\n")
        }
        fileEmployees.writeText(content.toString())
    }

    private fun loadAllEmployees(): MutableList<Worker> {
        val lines = fileEmployees.readLines()
        val employees = mutableListOf<Worker>()

        if (lines.isEmpty()) return employees

        for(line in lines) {
            val (id, name, age, salary, type) = line.split("%")
            val workerType = WorkerType.valueOf(type)

            val employee = when(workerType) {
                WorkerType.ACCOUNTANT -> Accountant(name, age.toInt(), id.toInt(), salary.toInt())
                WorkerType.DIRECTOR -> Director(name, age.toInt(), id.toInt(), salary.toInt())
                WorkerType.CONSULTANT -> Consultant(name, age.toInt(), id.toInt(), salary.toInt())
                WorkerType.ASSISTANT -> Assistant(name, age.toInt(), id.toInt(), salary.toInt())
            }

            employees.add(employee)
        }

        return employees
    }

    fun fireAnEmployee(id: Int) {
        for (employee in _employees) {
            if (employee.id == id) {
                _employees.remove(employee)
                break
            }
        }
    }

    fun changeSalary(id: Int, newSalary: Int) {
        for (employee in _employees) {
            if (employee.id == id) {
                employee.setSalary(newSalary)
                break
            }
        }
    }
}