package collections

fun main() {
    val numbers = mutableListOf<Number>()

    while (true) {
        val number = readln().toInt()
        if (number != 0) {
            numbers.add(number)
        } else {
            break
        }
    }
    numbers.forEach(::println)
}