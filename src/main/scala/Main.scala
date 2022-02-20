package ergonames

import ergonames.Box.BoxScanner._
import ergonames.Box.BoxUtils._
import ergonames.Box.BoxConfig.contractAddressRaw
import ergonames.Box.BoxUtils.printBoxesFromList
import ergonames.NodeConfiguration.NodeTools._
import ergonames.Utils.SystemUtils._
import ergonames.Utils.ErgoUtils._

import org.ergoplatform.appkit._
import org.ergoplatform.appkit.config.{ErgoNodeConfig, ErgoToolConfig}

import scala.collection.mutable.ListBuffer

object Main{

  def main(args: Array[String]): Unit = {
    val toolConfig = createToolConfig("testnet.json")
    val nodeConfig = creatNodeConfig(toolConfig)
    val client = createErgoClient(nodeConfig)

    clearScreen()
    systemHeader(nodeConfig)

    var onChainBoxes = scanBoxesAtAddress(contractAddressRaw, client)
    
    var boxesList: ListBuffer[Box.Box] = new ListBuffer[Box.Box]()
    
    var index: Int = 0
    for ( index <- 0 to onChainBoxes.size() - 1) {
      var box = new Box.Box(onChainBoxes.get(index))
      boxesList.append(box)
    }

    printBoxesFromList(boxesList)
  }

}