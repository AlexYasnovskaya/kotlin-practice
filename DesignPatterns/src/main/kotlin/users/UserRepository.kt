package users

import kotlinx.serialization.json.Json
import java.io.File

class UserRepository {
    constructor(password: String) {
        val correctPassword = File("password.txt").readText().trim()
        if (password != correctPassword) throw IllegalArgumentException("wrong password")
    }

    private val file = File("users.json")

    private val _users: MutableList<User> = loadAllUsers()
    val users
        get() = _users.toList()

    private fun loadAllUsers(): MutableList<User> = Json.decodeFromString(file.readText().trim())
}