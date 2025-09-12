package dogs

import kotlinx.serialization.json.Json
import java.io.File

class DogRepository private constructor(){
    private val file = File("dogs.json")

    private val _dogs: MutableList<Dog> = loadDogs()

    val dogs
        get() = _dogs.toList()
    private fun loadDogs(): MutableList<Dog> = Json.decodeFromString(file.readText().trim())

    companion object {
        private var instance: DogRepository? = null

        fun getInstance(password: String): DogRepository {
            val correctPassword = File("password.json").readText().trim()
            if (correctPassword != password) throw IllegalArgumentException("wrong password")
            if (instance == null) instance = DogRepository()

            return instance!!
        }
    }
}