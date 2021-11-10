package e2e

import console.io.Input

class FakeInput : Input {
    private var contentToRead = mutableListOf<String>()
    private var index = 0

    override fun readLine(): String {
        return contentToRead[index++]
    }

    fun willRead(message: String) {
        contentToRead.add(message)
    }

}