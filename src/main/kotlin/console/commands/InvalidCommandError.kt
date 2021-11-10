package console.commands

class InvalidCommandError(command: String) : Throwable("Invalid command $command")
