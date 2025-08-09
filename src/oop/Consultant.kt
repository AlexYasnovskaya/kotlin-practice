package oop

import kotlin.random.Random

class Consultant(
    val name: String,
    val age: Int
) {
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