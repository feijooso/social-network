package core.useCases

import core.domain.UserNotFoundError
import core.domain.UserRepository

class Login(private val userRepository: UserRepository) {
    fun execute(userName: String, password: String): Boolean {
        return try {
            val user = userRepository.get(userName)
            password == user.password
        } catch (e: UserNotFoundError){
            false
        }
    }

}
