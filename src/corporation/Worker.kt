package corporation

abstract class Worker(
    val name: String,
    val age: Int = 0,
    val id: Int,
    val salary: Int = 15000,
    val workerType: WorkerType
) {
    abstract fun copy(salary: Int = this.salary, age: Int = this.age): Worker

    override fun equals(other: Any?): Boolean {
        if (other !is Worker) return false

        return id == other.id
    }

    abstract fun work()

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "id: $id, name: $name, age: $age, salary: $salary, type: $workerType"
    }

    override fun hashCode(): Int {
        var result = age
        result = 31 * result + id
        result = 31 * result + salary
        result = 31 * result + name.hashCode()
        result = 31 * result + workerType.hashCode()
        return result
    }
}