import console.ConsoleApplication
import console.io.SystemInput
import console.io.SystemOutput

fun main() {
    val input = SystemInput()
    val output = SystemOutput()
    val console = ConsoleApplication(input, output)
    console.run()
}