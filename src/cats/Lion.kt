package cats

class Lion(val countInPride: Int): CatsFamily() {
    override fun eat() {
        println("im eating antelope")
    }
}