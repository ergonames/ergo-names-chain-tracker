package ergonames.SystemUtils

import org.ergoplatform.appkit.SecretString

object StringUtils {
    
    def convertToSecretString(str: String): SecretString = {
        val secret: SecretString = SecretString.create(str.toCharArray())
        secret
    }

}