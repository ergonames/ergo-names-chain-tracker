package ergonames.Box

import ergonames.Box.BoxConfig.contractAddressRaw
import ergonames.NodeConfiguration.NodeTools._
import ergonames.Ergo.ErgoUtils.createErgoAddress

import org.ergoplatform.appkit._

object BoxScanner {

    def scanBoxAtAddress(rawAddress: String, client: ErgoClient): java.util.List[InputBox] = {
        val contractAddress = createErgoAddress(rawAddress)
        var boxes = client.execute((ctx: BlockchainContext) => {
            val unspent = ctx.getUnspentBoxesFor(contractAddress, 0, 100)
            unspent
        })
        boxes
    }

}