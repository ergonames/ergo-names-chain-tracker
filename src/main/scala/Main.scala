package ergonames

import ergonames.Box.BoxScanner._
import ergonames.Box.BoxUtils._
import ergonames.Box.BoxConfig.contractAddressRaw
import ergonames.Box.BoxUtils.printBoxesFromList
import ergonames.NodeConfiguration.NodeTools._

import org.ergoplatform.appkit._
import org.ergoplatform.appkit.config.{ErgoNodeConfig, ErgoToolConfig}

object Main{

  def main(args: Array[String]): Unit = {
    println("Ergo Names Chain Tracker\n")
    
    val toolConfig = createToolConfig("testnet.json")
    val nodeConfig = creatNodeConfig(toolConfig)
    val client = createErgoClient(nodeConfig)

    val boxes = scanBoxesAtAddress(contractAddressRaw, client)
    printBoxesFromList(boxes)
    // val id = getBoxFunderAddress("ceca8efce65ea3b54b4904e15bfb907b4a66d5d347d15b4e3b8b5b1a1fa5945d")
  }

}