package corporation

open class Worker(
    val name: String,
    val age: Int = 0,
    val id: Int,
    val workerType: WorkerType
) {
    open fun work() {
        println("im working")
    }

    fun printInfo() {
        println("id: $id, name: $name, age: $age, type: $workerType")
    }
}