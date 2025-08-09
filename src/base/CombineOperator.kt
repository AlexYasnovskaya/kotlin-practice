package base

fun main() {
    println("Are u hungry?")
    val isHungry = readln().toBoolean()
    println("How much money do u have?")
    val money = readln().toInt()
    var phrase = ""
    val threshold = 500

    if (isHungry) {
        when {
            money >= threshold -> phrase = "Купите пиццу"
            else -> phrase = "Купите доширак"
        }
    } else {
        when {
            money >= threshold -> phrase = "Сходите в кино"
            else -> phrase = "Сходите на прогулку"
        }
    }

//    or

//    phrase = when {
//        money >= threshold -> if (isHungry) "Купите пиццу" else "Сходите в кино"
//        else -> if (isHungry) "Купите доширак" else "Сходите на прогулку"
//    }

    println(phrase)
}