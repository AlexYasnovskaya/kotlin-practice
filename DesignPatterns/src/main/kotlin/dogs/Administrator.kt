package dogs

import kotlin.system.exitProcess

class Administrator {
    private val repository = DogRepository.getInstance("qwerty")

    fun work() {
        while (true) {
            print("enter the operation code: ")
            val operations = Operations.entries
            for ((ind, operation) in operations.withIndex()) {
                print("$ind - ${operation.title};")
            }
            print("\n")
            val code = readln().toInt()
            val operation = operations[code]

            when(operation) {
                Operations.EXIT -> {
                    repository.saveChanges()
                    exitProcess(0)
                }
                Operations.ADD_NEW_DOG -> addDog()
                Operations.DELETE_DOG -> removeDog()
            }
        }
    }

    private fun addDog() {
        println("enter dog name: ")
        val dogName = readln()
        println("enter breed name: ")
        val breedName = readln()
        println("enter weight: ")
        val weight = readln().toDouble()

        repository.addDog(breedName, dogName, weight)
    }

    private fun removeDog() {
        println("enter id to remove: ")
        val id = readln().toInt()

        repository.removeDog(id)
    }
}