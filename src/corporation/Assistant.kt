package corporation

class Assistant(
    name: String,
    age: Int = 0,
    id: Int,
): Worker(name, age, id, WorkerType.ASSISTANT) {
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