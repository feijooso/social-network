package core.infrastructure

import core.domain.User
import core.domain.UserNotFoundError
import core.domain.UserRepository

class InMemoryUserRepository: UserRepository {
    private val users = mutableListOf<User>()

    override fun get(userName: String) =
        users.singleOrNull { it.userName == userName } ?: throw UserNotFoundError()

    override fun add(user: User) {
        users.add(user)
    }
}