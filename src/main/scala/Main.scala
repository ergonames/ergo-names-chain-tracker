package ergonames

import ergonames.NodeConfiguration.NodeTools._
import ergonames.NodeConfiguration.NodeWallet.getEIP3ErgoAddress
import ergonames.Http.HttpRequest.getDataFromDatabase

import org.ergoplatform.appkit._
import org.ergoplatform.appkit.config.{ErgoToolConfig, ErgoNodeConfig}

object Main{

  val toolConfig: ErgoToolConfig = createToolConfig("testnet.json")
  val nodeConfig: ErgoNodeConfig = creatNodeConfig(toolConfig)
  val client: ErgoClient = createErgoClient(nodeConfig)

  def main(args: Array[String]): Unit = {
    println("Ergo Names Backend\n")

    getDataFromDatabase()
  }

}