package cats

class Cat(val name: String): CatsFamily() {
    fun playWithMouse() {
        println("Im playing with mouse")
    }
}