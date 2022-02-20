package ergonames.Utils

import ergonames.Utils.ErgoUtils._
import org.ergoplatform.appkit.config.ErgoNodeConfig

object SystemUtils {

    def clearScreen() {
        print("\u001b[2J\u001b[;H")
    }

    def systemHeader(nodeConfig: ErgoNodeConfig) {
        println("Ergo Names Chain Tracker")
        println("Version 0.1.0")
        println()
        println("Chain Height: " + getChainHeight().toString())
        println("Network Type: " + getChainType(nodeConfig))
        println()
    }

    def millisecondsToSeconds(milliseconds: Int): Int = {
        val seconds: Int = milliseconds * 1000
        seconds
    }

}