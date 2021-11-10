package console.io

class SystemOutput: Output {
    override fun println(message: String) {
        kotlin.io.println(message)
    }
}
