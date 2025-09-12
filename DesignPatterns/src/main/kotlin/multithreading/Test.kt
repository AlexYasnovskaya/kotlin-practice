package multithreading

import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    val counter = Counter()

    val thread1 = thread {
        repeat(1_000_000) {
            counter.increment()
        }
    }

    val thread2 = thread {
        repeat(1_000_000) {
            counter.increment()
        }
    }

    thread1.join()
    thread2.join()

    println(counter.number)
}

class Counter {
    private val lock = Any()
    var number = 0

    fun increment() {
        synchronized(lock) {
            number++
        }
    }
}