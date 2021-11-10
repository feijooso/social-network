package console.commands

import core.infrastructure.InMemoryUserRepository
import core.useCases.Login

class CommandHandlerFactory {
    fun create(command: String): CommandHandler {
        when (command) {
            "login" -> return LoginHandler(Login(InMemoryUserRepository()))
            else -> throw InvalidCommandError(command)
        }
    }
}