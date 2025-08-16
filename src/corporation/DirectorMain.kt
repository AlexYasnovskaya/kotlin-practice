package corporation

fun main() {
    val director = WorkerRepository.findDirector()
        ?: throwDirectorIsRequired()
    director.printInfo()
}

fun throwDirectorIsRequired(): Nothing {
    throw IllegalStateException("Director is required for this program. Please add it to file")
}