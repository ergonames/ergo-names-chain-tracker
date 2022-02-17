package ergonames.Box

import ergonames.Box.BoxConfig.contractAddressRaw
import ergonames.NodeConfiguration.NodeTools._

import org.ergoplatform.appkit._

object BoxScanner {

    def scanBox(): java.util.List[InputBox] = {
        val contractAddress: Address = Address.create(contractAddressRaw)
        val toolConfig = createToolConfig("testnet.json")
        val nodeConfig = creatNodeConfig(toolConfig)
        val client = createErgoClient(nodeConfig)
        var a = client.execute((ctx: BlockchainContext) => {
            val unspent = ctx.getUnspentBoxesFor(contractAddress, 0, 100)
            val boxes = BoxOperations.selectTop(unspent, 1000L)
            boxes
        })
        a
    }

}