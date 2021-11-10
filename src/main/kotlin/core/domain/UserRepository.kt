package core.domain

interface UserRepository {
    fun get(userName: String): User
    fun add(user: User)
}
