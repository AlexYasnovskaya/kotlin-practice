package builder

fun main() {
    val drink = Drink.Builder()
        .type("tea")
        .build()
    println(drink)
}