package e2e

import console.io.Output

class FakeOutput : Output {
    var content = ""
        private set

    override fun println(message: String) {
        content += "$message/n"
    }

}