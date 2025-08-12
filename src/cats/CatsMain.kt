package cats

fun main() {
    val cat: Cat = Cat("Joe")
    val lion: Lion = Lion(25)
    val animals = listOf<CatsFamily>(cat, lion)
    for (animal in animals) {
        animal.eat()
    }
}