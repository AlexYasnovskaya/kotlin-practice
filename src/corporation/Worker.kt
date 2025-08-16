package corporation

abstract class Worker(
    val name: String,
    val age: Int = 0,
    val id: Int,
    val salary: Int = 15000,
    val workerType: WorkerType
) {
    abstract fun copy(salary: Int = this.salary, age: Int = this.age): Worker

    fun getSalary(): Int = salary

    abstract fun work()

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "id: $id, name: $name, age: $age, salary: $salary, type: $workerType"
    }
}