package console.commands

import core.useCases.Login
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoginHandlerShould {
    @Test
    fun `call Login with given username and password`() {
        loginHandler.handle(Command("login", listOf(alice, alicePassword)))

        verify { login.execute(alice, alicePassword) }
    }

    @Test
    fun `return success message when login succeeds`() {
        every { login.execute(any(), any()) } returns true

        val output = loginHandler.handle(loginCommand)

        assertThat(output).isEqualTo("Login successful")
    }

    @Test
    fun `return fail message when login fails`() {
        every { login.execute(any(), any()) } returns false

        val output = loginHandler.handle(loginCommand)

        assertThat(output).isEqualTo("Login fail")
    }

    @BeforeEach
    fun beforeEach() {
        every { login.execute(any(), any()) } returns true
    }
    private val alice = "@alice"
    private val alicePassword = "1234"
    private val loginCommand = Command("login", listOf(alice, alicePassword))
    private val login = mockk<Login>()
    private val loginHandler = LoginHandler(login)
}