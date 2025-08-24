package profile

fun main() {
    showEmails()
}

fun filterUsers() {
    ProfilesRepository.profiles
        .filter { it.age > 25 }
        .filter { it.firstName.startsWith("A") }
        .filter { it.gender == Gender.MALE }
        .filter { it.age < 30 }
        .map { it.copy(age = it.age + 1) }
        .sortedBy { it.firstName }
        .forEach(::println)
}

fun showEmails() {
    println("Enter user id: ")
    val id = readln().toInt()
    ProfilesRepository.profiles
        .find { it.id  == id }
        ?.let {
            println(it.email)
        }
        ?: println("user not found")
}