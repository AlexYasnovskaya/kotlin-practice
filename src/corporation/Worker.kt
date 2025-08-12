package corporation

abstract class Worker(
    val name: String,
    val age: Int = 0,
    val id: Int,
    val workerType: WorkerType
) {
    abstract fun work()

    fun printInfo() {
        println("id: $id, name: $name, age: $age, type: $workerType")
    }
}