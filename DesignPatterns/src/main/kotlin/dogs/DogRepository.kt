package dogs

import kotlinx.serialization.json.Json
import observer.MutableObservable
import java.io.File

class DogRepository private constructor() {
    private val file = File("dogs.json")
    private val _dogs: MutableList<Dog> = loadDogs()
    val dogs = MutableObservable(_dogs.toList())

    private fun loadDogs(): MutableList<Dog> = Json.decodeFromString(file.readText().trim())

    fun addDog(breedName: String, dogName: String, weight: Double) {
        val id = _dogs.maxOf { it.id } + 1
        _dogs.add(Dog(id, breedName, dogName, weight))
        dogs.currentValue = _dogs
    }

    fun removeDog(id: Int) {
        _dogs.removeIf { it.id == id }
        dogs.currentValue = _dogs
    }

    fun saveChanges() {
        val content = Json.encodeToString(_dogs)
        file.writeText(content)
    }
    companion object {
        private val lock = Any()
        private var instance: DogRepository? = null

        fun getInstance(password: String): DogRepository {
            val correctPassword = File("password.json").readText().trim()
            if (correctPassword != password) throw IllegalArgumentException("wrong password")

            instance?.let { return it }

            synchronized(lock) {
                instance?.let { return it }

                return DogRepository().also { instance = it }
            }
        }
    }
}