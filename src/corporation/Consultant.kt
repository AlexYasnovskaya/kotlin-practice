package corporation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int,
    id: Int
): Worker(name, age, id, WorkerType.CONSULTANT), Cleaner {
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

    override fun clean() {
        print("my position is ${super.workerType.title}. ")
        super.clean()
    }

    override fun work() {
        serveClients()
    }
}