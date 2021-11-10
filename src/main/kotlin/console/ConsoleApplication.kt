package console

import console.commands.Command
import console.commands.CommandHandlerFactory
import console.commands.InvalidCommandError
import console.io.Input
import console.io.Output

class ConsoleApplication(private val input: Input, private val output: Output) {
    private val commandFactory = CommandHandlerFactory()

    fun run() {
        while (true) {
            val command = readCommand()
            if (command.name == "exit") break
            process(command)
        }
        output.println("Bye")
    }

    private fun process(command: Command) {
        try {
            val commandOutput = commandFactory.create(command.name).handle(command)
            output.println(commandOutput)
        } catch (e: InvalidCommandError) {
            output.println(e.message!!)
        }
    }

    private fun readCommand(): Command {
        val commandText = input.readLine()
        val parts = commandText.split(" ")
        return Command(name = parts[0], parameters = parts.drop(1))
    }

}
