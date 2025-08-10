package corporation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int
): Worker(name, age) {
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
}