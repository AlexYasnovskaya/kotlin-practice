package corporation

class Director(
    override val name: String,
    override val age: Int,
    override val id: Int,
    override val salary: Int,
): Worker(name, age, id, salary,WorkerType.DIRECTOR), Supplier {

    fun takeCoffee(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()
        println("thanks, ${assistant.name}! $drinkName so tasty")
    }

    fun workConsultant(consultant: Consultant) {
        val count = consultant.serveClients()
        println("${consultant.name} completed servicing $count clients")
    }

    override fun copy(salary: Int, age: Int): Director {
        return Director(this.name, age, this.id, salary)
    }

    override fun buyingThings() {
        print("my position is ${super.workerType.title}. ")
        super.buyingThings()
    }

    override fun work() {
        println("im drinking coffee")
    }
}