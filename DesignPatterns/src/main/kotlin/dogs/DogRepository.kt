package dogs

import observer.Observer
import kotlinx.serialization.json.Json
import observer.Observable
import java.io.File

class DogRepository private constructor(): Observable<List<Dog>> {
    private val file = File("dogs.json")
    private val _observers = mutableListOf<Observer<List<Dog>>>()

    override val observers: List<Observer<List<Dog>>>
        get() = _observers.toList()

    private val _dogs: MutableList<Dog> = loadDogs()
    override val currentCollection: List<Dog>
        get() = _dogs.toList()

    private fun loadDogs(): MutableList<Dog> = Json.decodeFromString(file.readText().trim())

    override fun registerObserver(observer: Observer<List<Dog>>) {
        _observers.add(observer)
        observer.onChanged(currentCollection)
    }
    fun addOnDogsChangedListener(observer: Observer<List<Dog>>) {
        registerObserver(observer)
    }

    override fun unregisterObserver(observer: Observer<List<Dog>>) {
        _observers.remove(observer)
    }

    fun addDog(breedName: String, dogName: String, weight: Double) {
        val id = _dogs.maxOf { it.id } + 1
        _dogs.add(Dog(id, breedName, dogName, weight))
        notifyObservers()
    }

    fun removeDog(id: Int) {
        _dogs.removeIf { it.id == id }
        notifyObservers()
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