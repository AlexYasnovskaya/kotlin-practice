package users

fun main() {
    UserRepository(password = "").users.forEach { println(it) }
}