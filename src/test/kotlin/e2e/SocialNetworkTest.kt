package e2e

import console.ConsoleApplication
import e2e.FakeInput
import e2e.FakeOutput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SocialNetworkTest {

    @Test
    fun exit() {
        input.willRead("exit")

        console.run()

        assertThat(output.content).isEqualTo("Bye/n")
    }

    @Test
    fun login() {
        input.willRead("login sofi sofisofi")
        input.willRead("exit")

        console.run()

        assertThat(output.content).isEqualTo("Login successful/nBye/n")
    }

    private val input = FakeInput()
    private val output = FakeOutput()
    private val console = ConsoleApplication(input, output)


}

