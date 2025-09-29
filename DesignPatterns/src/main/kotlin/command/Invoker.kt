package command

interface Invoker<T: Command> { // можно использовать реализации только типа комманд или его наследников
    fun addCommand(command: T)
}