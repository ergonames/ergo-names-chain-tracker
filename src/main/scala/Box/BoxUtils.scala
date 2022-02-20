package ergonames.Box

import ergonames.Http.HttpRequest._
import ergonames.Http.HttpConfig.ergoTestnetAPIUrl
import ergonames.SystemUtils.StringUtils._

import scalaj.http._
import org.ergoplatform.appkit.InputBox
import spray.json._
import DefaultJsonProtocol._

object BoxUtils {

    def getBoxFunderAddress(transactionId: String): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/transactions/" + transactionId
        val transactionData = getData(url)
        val transactionJson = convertStringToJsObject(transactionData)
        val inputsData = transactionJson.getFields("inputs")(0).toString()
        val adjustedInputsData = removeFirstAndLastCharacter(inputsData)
        val addressJson = convertStringToJsObject(adjustedInputsData)
        val address = addressJson.getFields("address")(0).toString()
        val adjustedAddress = removeFirstAndLastCharacter(address)
        adjustedAddress
    }

    def getBoxTransactionId(box: InputBox): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + box.getId()
        val boxData = getData(url)
        val boxAST = boxData.parseJson
        val boxJson = boxAST.asJsObject
        val transactionIdRaw = boxJson.getFields("transactionId")(0).toString()
        val transactionId = removeFirstAndLastCharacter(transactionIdRaw)
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