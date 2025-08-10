package cats

fun main() {
    val cat: Cat = Cat("Joe")
    println("legs: ${cat.legsCount}, name: ${cat.name}")

    val lion: Lion = Lion(25)
    println("legs: ${lion.legsCount}, count in pride: ${lion.countInPride}")
}