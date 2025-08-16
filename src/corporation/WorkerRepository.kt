package corporation

import java.io.File

object WorkerRepository {
    private val fileEmployees = File("employees.txt")
    private val _employees = loadAllEmployees()
    val employees
        get() = _employees.toList()

    fun registerNewEmployee(newEmployee: Worker) {
        _employees.add(newEmployee)
    }

    fun saveChanges() {
        var content = StringBuilder()
        for (employee in _employees) {
            content.append("${employee.id}%${employee.name}%${employee.age}%${employee.salary}%${employee.workerType}\n")
        }
        fileEmployees.writeText(content.toString())
    }

    private fun loadAllEmployees(): MutableSet<Worker> {
        val lines = fileEmployees.readLines()
        val employees = mutableSetOf<Worker>()

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
                val newEmployee = employee.copy(newSalary)
                _employees.remove(employee)
                _employees.add(newEmployee)
                break
            }
        }
    }

    fun changeAge(id: Int, newAge: Int) {
        for (employee in _employees) {
            if (employee.id == id) {
                val newEmployee = employee.copy(age = newAge)
                _employees.remove(employee)
                _employees.add(newEmployee)
                break
            }
        }
    }
}