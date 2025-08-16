package corporation

data class Assistant(
    override val name: String,
    override val age: Int = 0,
    override val id: Int,
    override val salary: Int
): Worker(name, age, id, salary, WorkerType.ASSISTANT), Cleaner, Supplier {
    fun bringCoffee(count: Int = 1, type: String = "cappuccino"): String {
        repeat(count) {
            println("Bring $type")
        }
        return type
    }

    override fun copy(salary: Int, age: Int): Assistant {
        return Assistant(this.name, age, this.id, salary)
    }

    override fun clean() {
        print("my position is ${super.workerType.title}. ")
        super.clean()
    }

    override fun buyingThings() {
        print("my position is ${super.workerType.title}. ")
        super.buyingThings()
    }

    override fun work() {
        println("im bringing coffee to the director")
    }
}