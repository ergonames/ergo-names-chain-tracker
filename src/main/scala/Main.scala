package ergonames

import ergonames.Box.BoxScanner._
import ergonames.Box.BoxConfig.contractAddressRaw
import ergonames.NodeConfiguration.NodeTools._

import org.ergoplatform.appkit._
import org.ergoplatform.appkit.config.{ErgoNodeConfig, ErgoToolConfig}

object Main{

  def main(args: Array[String]): Unit = {
    println("Ergo Names Backend\n")
    
    val toolConfig = createToolConfig("testnet.json")
    val nodeConfig = creatNodeConfig(toolConfig)
    val client = createErgoClient(nodeConfig)

    val boxes = scanBoxAtAddress(contractAddressRaw, client)
    var a = 0
    for ( a <- 0 to boxes.size() - 1) {
      println(boxes.get(a))
    }
  }

}