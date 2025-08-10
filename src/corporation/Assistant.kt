package corporation

class Assistant(
    name: String,
    age: Int = 0
): Worker(name, age) {
    fun bringCoffee(count: Int = 1, type: String = "cappuccino"): String {
        repeat(count) {
            println("Bring $type")
        }
        return type
    }

    override fun work() {
        println("im bringing coffee to the director")
    }
}