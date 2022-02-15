package ergonames.NodeConfiguration

import ergonames.SystemUtils.StringUtils.convertToSecretString

import org.ergoplatform.appkit.{Address, Mnemonic, NetworkType, SecretString}
import org.ergoplatform.appkit.config.ErgoNodeConfig

object NodeWallet {

    private def getWalletString(nodeConfig: ErgoNodeConfig): String = {
        val mnemonicString: String = nodeConfig.getWallet().getMnemonic()
        mnemonicString
    }

    private def getWalletPassword(nodeConfig: ErgoNodeConfig): String = {
        val mnemonicPassword: String = nodeConfig.getWallet().getPassword()
        mnemonicPassword
    }

    def getEIP3ErgoAddress(nodeConfig: ErgoNodeConfig): Address = {
        val walletMnemonic: SecretString = convertToSecretString(getWalletString(nodeConfig))
        val walletPassoword: SecretString = convertToSecretString(getWalletPassword(nodeConfig))
        val address: Address = Address.createEip3Address(0, NetworkType.TESTNET, walletMnemonic, walletPassoword)
        address        
    }
}