package collections

fun main() {
    val numbers = mutableListOf<Int>()
    repeat(100) {
        numbers.add(it)
    }
    for(number in numbers) {
        println(number)
    }
}