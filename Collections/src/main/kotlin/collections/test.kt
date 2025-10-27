package collections

fun main() {
    val numbers = sortedSetOf<String>()
    repeat(100) {
        numbers.add("Number: $it")
    }
    for(number in numbers) {
        println(number)
    }
}