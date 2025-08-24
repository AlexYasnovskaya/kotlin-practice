package profile

fun main() {
    val profiles = ProfilesRepository.profiles
        .filter { it.age > 25 }
        .filter { it.firstName.startsWith("A") }
        .filter { it.gender == Gender.MALE }
        .filter { it.age < 30 }
        .map { it.copy(age = it.age + 1) }

    for (profile in profiles) {
        println(profile)
    }
}