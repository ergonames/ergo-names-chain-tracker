package ergonames.Utils

object SystemUtils {

    def clearScreen() {
        print("\u001b[2J\u001b[;H")
    }

    def systemHeader() {
        println("Ergo Names Chain Tracker")
        println("Version 0.1.0")
        println()
    }

}