package console.io

class SystemInput : Input {
    override fun readLine(): String {
        return kotlin.io.readLine() ?: ""
    }
}
