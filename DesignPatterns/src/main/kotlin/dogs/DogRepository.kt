package dogs

import kotlinx.serialization.json.Json
import observer.MutableObservable
import observer.Observable
import java.io.File

class DogRepository private constructor() {
    private val file = File("dogs.json")
    private val dogsList: MutableList<Dog> = loadDogs()
    private val _dogs = MutableObservable(dogsList.toList())
    val dog: Observable<List<Dog>>
        get() = _dogs

    private fun loadDogs(): MutableList<Dog> = Json.decodeFromString(file.readText().trim())

    fun addDog(breedName: String, dogName: String, weight: Double) {
        val id = dogsList.maxOf { it.id } + 1
        dogsList.add(Dog(id, breedName, dogName, weight))
        _dogs.currentValue = dogsList
    }

    fun removeDog(id: Int) {
        dogsList.removeIf { it.id == id }
        _dogs.currentValue = dogsList
    }

    fun saveChanges() {
        val content = Json.encodeToString(dogsList)
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