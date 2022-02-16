package ergonames.Database

import ergonames.Http.HttpRequest.getDataFromDatabase
import ergonames.Http.HttpRequest.convertHttpResponseToJSON

object TokenUtils {

    def checkAlreadyRegistered(tokenName: String): Boolean = {
        val response = getDataFromDatabase(tokenName)
        val jsonData = convertHttpResponseToJSON(response)
        val ownerAddress = getOwnerAddress(jsonData)
        if (ownerAddress == null) {
            false
        } else {
            true
        }
    }

    def getOwnerAddress(data: Map[String, String]): String = {
        val ownerAddress = data.getOrElse("ergo", "Cannot read owner address")
        ownerAddress
    }
}