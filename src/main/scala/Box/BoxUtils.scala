package ergonames.Box

import ergonames.Http.HttpConfig.ergoTestnetAPIUrl

import scalaj.http._
import org.ergoplatform.appkit.InputBox
import spray.json._
import DefaultJsonProtocol._

object BoxUtils {

    def getBoxFunderAddress(transactionId: String): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/transactions/" + transactionId
        val response = Http(url).asString
        val transactionData = response.body
        val transactionAST = transactionData.parseJson
        val transactionJson = transactionAST.asJsObject
        val inputsData = transactionJson.getFields("inputs")(0).toString()
        val adjustedInputsData = inputsData.substring(1, inputsData.length()-1)
        val addressAST = adjustedInputsData.parseJson
        val addressJson = addressAST.asJsObject
        val address = addressJson.getFields("address")(0).toString()
        val adjustedAddress = address.substring(1, address.length()-1)
        adjustedAddress
    }

    def getBoxTransactionId(box: InputBox): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + box.getId()
        val response = Http(url).asString
        val boxData = response.body
        val boxAST = boxData.parseJson
        val boxJson = boxAST.asJsObject
        val transactionIdRaw = boxJson.getFields("transactionId")(0).toString()
        val transactionId = transactionIdRaw.substring(1, transactionIdRaw.length()-1)
        transactionId
    }

    def printBoxesFromList(boxes: java.util.List[InputBox]) {
        var index: Int = 0
        for ( index <- 0 to boxes.size() - 1) {
            //println(boxes.get(index))
            println("Box Id:\t\t\t" + boxes.get(index).getId())
            println("Transaction Id:\t\t" + getBoxTransactionId(boxes.get(index)))
            println("Funder Address:\t\t" + getBoxFunderAddress(getBoxTransactionId(boxes.get(index))))
            println()
        }
    }
}