package profile

fun main() {
    val profiles = ProfilesRepository.profiles
        .filter { it.age > 25 }
        .filter { it.firstName.startsWith("A") }
        .filter { it.gender == Gender.MALE }
        .filter { it.age < 30 }
        .transform { it.copy(age = it.age + 1) }

    for (profile in profiles) {
        println(profile)
    }
}

fun List<Person>.filter(isSuitable: (Person) -> Boolean): List<Person> {
    val result = mutableListOf<Person>()

    for (profile in this) {
        if (isSuitable(profile)) {
            result.add(profile)
        }
    }

    return result.toList()
}

fun <T> List<Person>.transform( operation: (Person) -> T): List<T> {
    val result = mutableListOf<T>()
    for (profile in this) {
        result.add(operation(profile))
    }
    return  result
}