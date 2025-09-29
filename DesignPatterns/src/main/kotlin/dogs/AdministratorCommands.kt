package dogs

import command.Command

sealed interface AdministratorCommands: Command {
    data class AddDog(
        val repository: DogRepository,
        val breedName: String,
        val dogName: String,
        val weight: Double
    ): AdministratorCommands {
        override fun execute() {
            repository.addDog(breedName, dogName, weight)
        }
    }

    data class DeleteDog(
        val repository: DogRepository,
        val id: Int
    ): AdministratorCommands {
        override fun execute() {
            repository.removeDog(id)
        }
    }

    data class SaveChanges(
        val repository: DogRepository,
    ): AdministratorCommands {
        override fun execute() {
            repository.saveChanges()
        }
    }
}