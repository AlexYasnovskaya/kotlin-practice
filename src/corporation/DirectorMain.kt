package corporation

fun main() {
    val workers = WorkerRepository.employees
    workers.add(Consultant("Joe", 24, 14, 35000))
    for (worker in workers) {
        worker.work()
    }
}