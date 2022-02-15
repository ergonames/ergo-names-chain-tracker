package ergonames.NodeConfiguration

import org.ergoplatform.appkit.{ErgoClient, RestApiErgoClient}
import org.ergoplatform.appkit.config.{ErgoToolConfig, ErgoNodeConfig}

object NodeTools {

    private val defaultMainnetExplorerUrl = "https://api.ergoplatform.com"
    private val defaultTestnetExplorerUrl = "https://api-testnet.ergoplatform.com"

    def createToolConfig(configFile: String): ErgoToolConfig = {
        val config: ErgoToolConfig = ErgoToolConfig.load(configFile)
        config
    }

    def creatNodeConfig(toolConfig: ErgoToolConfig): ErgoNodeConfig = {
        val config: ErgoNodeConfig = toolConfig.getNode()
        config
    }

    def createErgoClient(nodeConfig: ErgoNodeConfig): ErgoClient = {
        val client: ErgoClient = RestApiErgoClient.create(nodeConfig, defaultTestnetExplorerUrl)
        client
    }
}