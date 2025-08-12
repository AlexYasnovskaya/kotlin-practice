package cats

class Cat(val name: String): CatsFamily() {
    fun playWithMouse() {
        println("Im playing with mouse")
    }

    override fun eat() {
        println("im eating wiskis")
    }
}