package ergonames.Ergo

import org.ergoplatform.appkit.Address

object ErgoUtils {

    def createErgoAddress(rawAddress: String): Address = {
        val address: Address = Address.create(rawAddress)
        address
    }

}