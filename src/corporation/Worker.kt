package corporation

abstract class Worker(
    val name: String,
    val age: Int = 0,
    val id: Int,
    val workerType: WorkerType
) {
    var salary: Int =  15000
        set(value) {
            if (value < field) {
                println("the new salary is too small")
            } else {
                field = value
            }
        }

//    fun setSalary(salary: Int) {
//        if (salary < this.salary) {
//            println("the new salary is too small")
//        } else {
//            this.salary = salary
//        }
//    }
//
//    fun getSalary(): Int {
//        return salary
//    }

    abstract fun work()

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "id: $id, name: $name, age: $age, salary: $salary, type: $workerType"
    }
}