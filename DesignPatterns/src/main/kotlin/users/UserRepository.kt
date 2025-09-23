package users

import observer.Observer
import kotlinx.serialization.json.Json
import observer.Observable
import java.io.File

class UserRepository private constructor(): Observable<List<User>> {

    private val file = File("users.json")

    private val _observers = mutableListOf<Observer<List<User>>>()
    override val observers
        get() = _observers.toList()

    private val _users: MutableList<User> = loadAllUsers()
    override val currentCollection: List<User>
        get() = _users.toList()

    private fun loadAllUsers(): MutableList<User> = Json.decodeFromString(file.readText().trim())

    override fun registerObserver(observer: Observer<List<User>>) {
        _observers.add(observer)
        observer.onChanged(currentCollection)
    }

    override fun unregisterObserver(observer: Observer<List<User>>) {
        _observers.remove(observer)
    }

    fun addOnUsersChangedListener(observer: Observer<List<User>>) {
        registerObserver(observer)
    }

    fun addUser(firstName: String, lastName: String, age: Int) {
        val id = currentCollection.maxOf { it.id } + 1
        _users.add(User(id = id, firstName = firstName, lastName = lastName, age = age))
        notifyObservers()
    }

    fun deleteUser(id: Int) {
        _users.removeIf { it.id == id }
        notifyObservers()
    }

    fun saveChanges() {
        val content = Json.encodeToString(_users)
        file.writeText(content)
        notifyObservers()
    }

    companion object {
        private val lock = Any()
        private var instance: UserRepository? = null

        fun getInstance(password: String): UserRepository {
            val correctPassword = File("password.json").readText().trim()
            if (password != correctPassword) throw IllegalArgumentException("wrong password")

            instance?.let { return it }

            synchronized(lock) {
                instance?.let { return it }

                return UserRepository().also { instance = it }
            }
        }
    }
}