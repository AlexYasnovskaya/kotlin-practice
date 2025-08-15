package corporation

class Director(
    name: String,
    age: Int,
    id: Int,
    salary: Int,
): Worker(name, age, id, salary,WorkerType.DIRECTOR), Supplier {

    fun takeCoffee(assistant: Assistant) {
        val drinkName = assistant.bringCoffee()
        println("thanks, ${assistant.name}! $drinkName so tasty")
    }

    fun workConsultant(consultant: Consultant) {
        val count = consultant.serveClients()
        println("${consultant.name} completed servicing $count clients")
    }

    override fun buyingThings() {
        print("my position is ${super.workerType.title}. ")
        super.buyingThings()
    }

    override fun work() {
        println("im drinking coffee")
    }
}