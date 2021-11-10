package core.useCases

import core.domain.User
import core.infrastructure.InMemoryUserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LoginShould {
    @Test
    fun `return true if credentials are valid`() {
        userRepository.add(User(alice, alicePassword))

        val isSuccess = login.execute(alice, alicePassword)

        assertThat(isSuccess).isTrue
    }

    @Test
    fun `return false if user doesnt exist`() {
        val isSuccess = login.execute(nonExistentUser, alicePassword)

        assertThat(isSuccess).isFalse
    }
    @Test
    fun `return false if password is invalid`() {
        userRepository.add(User(alice, alicePassword))

        val isSuccess = login.execute(alice, invalidPassword)

        assertThat(isSuccess).isFalse
    }

    private val alice = "@alice"
    private val alicePassword = "1234"
    private val nonExistentUser = "@bob"
    private val invalidPassword = "invalid"
    private val userRepository = InMemoryUserRepository()
    private val login = Login(userRepository)
}
