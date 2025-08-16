package corporation

fun main() {
    val workers = WorkerRepository.employees
    for (worker in workers) {
        worker.work()
    }
}