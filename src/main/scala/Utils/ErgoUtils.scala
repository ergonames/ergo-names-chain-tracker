package ergonames.Utils

import ergonames.Http.HttpConfig.ergoTestnetAPIUrl
import ergonames.Http.HttpRequest._
import ergonames.Utils.StringUtils._

import org.ergoplatform.appkit.NetworkType
import org.ergoplatform.appkit.config.ErgoNodeConfig

object ErgoUtils {

    def getChainHeight(): Int = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/networkState"
        val response = getData(url)
        val networkStateJson = convertStringToJsObject(response)
        val chainHeightData = networkStateJson.getFields("height")(0).toString()
        chainHeightData.toInt
    }

    def getChainType(nodeConfig: ErgoNodeConfig): NetworkType = {
        nodeConfig.getNetworkType()
    }
}
