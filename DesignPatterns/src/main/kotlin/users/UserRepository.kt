package users

import observer.Observer
import kotlinx.serialization.json.Json
import java.io.File

class UserRepository private constructor(){

    private val file = File("users.json")
    private val observers = mutableListOf<Observer<List<User>>>()

    private val _users: MutableList<User> = loadAllUsers()
    val users
        get() = _users.toList()

    private fun loadAllUsers(): MutableList<User> = Json.decodeFromString(file.readText().trim())

    private fun notifyObservers() {
        for (observer in observers) {
            observer.onChanged(users)
        }
    }

    fun addListener(observer: Observer<List<User>>) {
        observers.add(observer)
        observer.onChanged(users)
    }

    fun addUser(firstName: String, lastName: String, age: Int) {
        val id = users.maxOf { it.id } + 1
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