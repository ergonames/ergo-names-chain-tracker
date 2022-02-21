package ergonames.System

import ergonames.Utils.SystemUtils.millisecondsToSeconds
import ergonames.Utils.SystemUtils.clearScreen
import ergonames.Utils.SystemUtils.systemHeader

import ergonames.Box.BoxScanner._
import ergonames.Box.BoxUtils._
import ergonames.Box.BoxConfig.contractAddressRaw
import ergonames.Box.Box
import ergonames.Utils.ErgoUtils._

import org.ergoplatform.appkit.ErgoClient
import org.ergoplatform.appkit.config.ErgoNodeConfig
import scala.collection.mutable.ListBuffer
import org.ergoplatform.appkit.NetworkType

object Loop {

    def loop(nodeConfig: ErgoNodeConfig ,client: ErgoClient, boxesList: ListBuffer[Box], networkType: NetworkType) {
        val systemOn = true
        while (systemOn) {
            clearScreen()
            systemHeader(nodeConfig, networkType)

            var totalValueInBoxes = getTotalBoxesValue(boxesList)
            println("Total Boxes At Address:\t\t\t" + boxesList.size.toString())
            println("Total Value In Boxes (NanoErg):\t\t" + getTotalBoxesValue(boxesList).toString())
            println("Total Value In Boxes (Ergs):\t\t" + nanoErgToErg(totalValueInBoxes).toString())
            println()

            println("First 5 Boxes")
            var firstFiveIndex: Int = 0
            for ( firstFiveIndex <- 0 to 4) {
                println("Box " + (firstFiveIndex + 1).toString() + ":\t" + boxesList(firstFiveIndex).getId())
            }

            Thread.sleep(millisecondsToSeconds(3))
        }
    }
}