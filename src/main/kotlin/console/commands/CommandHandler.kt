package console.commands

interface CommandHandler {
    fun handle(command: Command): String
}