package users

import kotlin.system.exitProcess

class Administrator {
    private val repository = UserRepository.getInstance("qwerty")

    fun work() {
        while (true) {
            print("Enter the operation code: ")
            val operations = Operations.entries
            for((ind, operation) in operations.withIndex()) {
                print("$ind - ${operation.title}; ")
            }
            print("\n")
            val code = readln().toInt()
            val operation = operations[code]

            when(operation) {
                Operations.EXIT -> {
                    repository.saveChanges()
                    exitProcess(0)
                }
                Operations.ADD_NEW_USER -> addUser()
                Operations.DELETE_USER -> deleteUser()
            }
        }
    }

    private fun addUser() {
        println("enter first name: ")
        val firstName = readln()
        println("enter last name: ")
        val lastName = readln()
        println("enter age: ")
        val age = readln().toInt()

        UsersInvoker.addCommand {
            repository.addUser(firstName, lastName, age)
        }
    }

    private fun deleteUser() {
        println("enter user id: ")
        val id = readln().toInt()

        UsersInvoker.addCommand {
            repository.deleteUser(id)
        }
    }
}