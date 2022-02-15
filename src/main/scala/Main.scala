package ergonames

import ergonames.NodeConfiguration.NodeTools._
import ergonames.NodeConfiguration.NodeWallet.getEIP3ErgoAddress

import org.ergoplatform.appkit._
import org.ergoplatform.appkit.config.{ErgoToolConfig, ErgoNodeConfig}

object Main{

  val toolConfig: ErgoToolConfig = createToolConfig("testnet.json")
  val nodeConfig: ErgoNodeConfig = creatNodeConfig(toolConfig)
  val client: ErgoClient = createErgoClient(nodeConfig)

  def main(args: Array[String]): Unit = {
    println("Ergo Names Backend")

    val nodeAddress: Address = getEIP3ErgoAddress(nodeConfig)
    println(nodeAddress.asP2PK())
  }
}