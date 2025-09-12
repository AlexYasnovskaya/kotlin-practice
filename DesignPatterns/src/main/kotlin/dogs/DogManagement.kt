package dogs

fun main() {
    DogRepository.getInstance("qwerty").dogs.forEach { println(it) }
}