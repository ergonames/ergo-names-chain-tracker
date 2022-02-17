package ergonames.Database

import ergonames.Http.HttpRequest.getDataFromDatabase
import ergonames.Http.HttpRequest.convertHttpResponseToJSON
import ergonames.Http.HttpRequest.parseJSONData

object TokenUtils {

    def checkAlreadyRegistered(tokenName: String): Boolean = {
        val response = getDataFromDatabase(tokenName)
        val jsonData = convertHttpResponseToJSON(response)
        val ownerAddress = getOwnerAddress(jsonData)
        if (ownerAddress == "None") {
            false
        } else {
            true
        }
    }

    def getOwnerAddress(data: Map[String, Option[String]]): String = {
        val ownerAddress = parseJSONData(data, "ergo", "Cannot read owner address from response.")
        ownerAddress
    }
}