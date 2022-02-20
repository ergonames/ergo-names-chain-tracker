package ergonames.SystemUtils

import org.ergoplatform.appkit.SecretString
import spray.json._

object StringUtils {
    
    def convertToSecretString(str: String): SecretString = {
        val secret: SecretString = SecretString.create(str.toCharArray())
        secret
    }

    def removeFirstAndLastCharacter(str: String): String = {
        val newStr = str.substring(1, str.length()-1)
        newStr
    }

    def convertStringToJsObject(str: String): JsObject = {
        val ast = str.parseJson
        val json = ast.asJsObject
        json
    }

}