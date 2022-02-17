package ergonames

import ergonames.Box.BoxScanner._
import ergonames.Box.BoxConfig.contractAddressRaw
import ergonames.Box.BoxUtils.printBoxesFromList
import ergonames.NodeConfiguration.NodeTools._

import org.ergoplatform.appkit._
import org.ergoplatform.appkit.config.{ErgoNodeConfig, ErgoToolConfig}

object Main{

  def main(args: Array[String]): Unit = {
    println("Ergo Names Backend\n")

    val toolConfig = createToolConfig("testnet.json")
    val nodeConfig = creatNodeConfig(toolConfig)
    val client = createErgoClient(nodeConfig)

    val boxes = scanBoxesAtAddress(contractAddressRaw, client)
    printBoxesFromList(boxes)
  }

}