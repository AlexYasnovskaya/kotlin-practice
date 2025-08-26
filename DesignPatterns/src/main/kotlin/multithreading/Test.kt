package multithreading

import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
//    thread { // (object: Runnable { override fun run()})
//        repeat(100_000) {
//            print(" 0 ")
//        }
//    }

    print("Enter the number from 1 to 1000_000_000: ")
    val userNumber = readln().toInt()
    var check = true
    thread {
       while (true) {
           val computerNumber = Random.nextInt(1_000_000_001)
           if (userNumber == computerNumber) {
               println("I win. Your number is: $computerNumber")
               check = false
               break
           }
       }
    }
    thread {
        var second = 1
        while (check) {
            println(second++)
            Thread.sleep(1000)
        }
    }
}