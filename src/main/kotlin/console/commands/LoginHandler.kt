package console.commands

import core.infrastructure.InMemoryUserRepository
import core.useCases.Login

class LoginHandler(private val login: Login) : CommandHandler {
    override fun handle(command: Command): String {
        val userName = command.parameters[0]
        val password = command.parameters[1]
        val isSuccess = login.execute(userName, password)

        return if (isSuccess) {
            "Login successful"
        } else {
            "Login fail"
        }
    }

}
