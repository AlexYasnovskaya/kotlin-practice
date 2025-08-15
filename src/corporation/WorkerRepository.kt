package corporation

import java.io.File

class WorkerRepository {
    private val fileEmployees = File("employees.txt")

    fun registerNewEmployee(employee: Worker) {
        saveAnEmployeeToFile(employee)
    }

    private fun saveAnEmployeeToFile(employee: Worker) {
        fileEmployees.appendText("${employee.id}%${employee.name}%${employee.age}%${employee.getSalary()}%${employee.workerType}\n")
    }

    fun loadAllEmployees(): MutableList<Worker> {
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
        val employees = loadAllEmployees()
        fileEmployees.writeText("")

        for ((ind, employee) in employees.withIndex()) {
            if (employee.id != id) {
                saveAnEmployeeToFile(employee)
            }
        }
    }

    fun changeSalary(id: Int, newSalary: Int) {
        val employees = loadAllEmployees()
        fileEmployees.writeText("")

        for (employee in employees) {
            if (employee.id == id) {
                employee.setSalary(newSalary)
                break
            }
            saveAnEmployeeToFile(employee)
        }
    }
}