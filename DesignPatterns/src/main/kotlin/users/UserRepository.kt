package users

import kotlinx.serialization.json.Json
import java.io.File

class UserRepository private constructor(){

    private val file = File("users.json")

    private val _users: MutableList<User> = loadAllUsers()
    val users
        get() = _users.toList()

    private fun loadAllUsers(): MutableList<User> = Json.decodeFromString(file.readText().trim())

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