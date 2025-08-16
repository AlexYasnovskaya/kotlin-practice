package corporation

fun main() {
    val assistant = WorkerRepository.findAssistant()
    assistant?.work()
    val director = WorkerRepository.findDirector()
    if (assistant != null) {
        director?.takeCoffee(assistant)
    }

    val directorSalary = director?.salary ?: 0
    val assistantSalary = assistant?.salary ?: 0
    val sum = directorSalary + assistantSalary
}