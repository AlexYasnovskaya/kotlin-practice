package corporation

fun main() {
    val assistant = WorkerRepository.findAssistant()
    assistant?.work()
    val director = WorkerRepository.findDirector()
    if (assistant != null) {
        director?.takeCoffee(assistant)
    }
}