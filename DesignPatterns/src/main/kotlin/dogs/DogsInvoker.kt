package dogs

import command.Command
import command.Invoker
import java.util.concurrent.LinkedBlockingDeque
import kotlin.concurrent.thread

object DogsInvoker: Invoker<AdministratorCommands> {
    private val commands = LinkedBlockingDeque<Command>()

    init {
        thread {
            while (true) {
                println("waiting...")
                val command = commands.take()
                println("execute: $command")
                command.execute()
                println("executed: $command")
            }
        }
    }

    override fun addCommand(command: AdministratorCommands) {
        println("new command: $command")
        commands.add(command)
    }
}