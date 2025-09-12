package users

fun main() {
    UserRepository.getInstance("qwerty").users.forEach { println(it) }
}