package profile

fun main() {
    val profiles = ProfilesRepository.profiles
    var filtered = filter(profiles) { it.age > 25 }
    filtered = filter(filtered) { it.firstName.startsWith("A") }
    filtered = filter(filtered) { it.gender == Gender.MALE }

    for (profile in filtered) {
        println(profile)
    }
}

fun filter(profiles: List<Person>, isSuitable: (Person) -> Boolean): List<Person> {
    val result = mutableListOf<Person>()

    for (profile in profiles) {
        if (isSuitable(profile)) {
            result.add(profile)
        }
    }

    return result.toList()
}