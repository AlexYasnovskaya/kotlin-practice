package oop

class Assistant {
    fun bringCoffee(count: Int, type: String = "capuchinno") {
        repeat(count) {
            println("Bring $type")
        }
    }
}