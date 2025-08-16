package corporation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int,
    id: Int,
    salary: Int,
): Worker(name, age, id, salary, WorkerType.CONSULTANT), Cleaner {
    fun sayHello() {
        println("hello. im $name.")
        if (age > 0) println("im $age.")
    }

    fun serveClients(): Int {
        val count = Random.nextInt(1, 20)
        repeat(count) {
            println("client served")
        }

        return count
    }

    override fun copy(salary: Int, age: Int): Consultant {
        return Consultant(this.name, age, this.id, salary)
    }

    override fun clean() {
        print("my position is ${super.workerType.title}. ")
        super.clean()
    }

    override fun work() {
        serveClients()
    }
}