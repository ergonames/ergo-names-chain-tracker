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
        val boxJson = convertStringToJsObject(boxData)
        val transactionIdRaw = boxJson.getFields("transactionId")(0).toString()
        val transactionId = removeFirstAndLastCharacter(transactionIdRaw)
        transactionId
    }

    def getBoxValue(box: InputBox): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + box.getId()
        val boxData = getData(url)
        val boxJson = convertStringToJsObject(boxData)
        val value = boxJson.getFields("value")(0).toString()
        value
    }

    def getCreationHeight(box: InputBox): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + box.getId()
        val boxData = getData(url)
        val boxJson = convertStringToJsObject(boxData)
        val creationHeight = boxJson.getFields("creationHeight")(0).toString()
        creationHeight
    }

    def getSettlementHeight(box: InputBox): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + box.getId()
        val boxData = getData(url)
        val boxJson = convertStringToJsObject(boxData)
        val settlementHeight = boxJson.getFields("settlementHeight")(0).toString()
        settlementHeight
    }

    def printBoxesFromList(boxes: java.util.List[InputBox]) {
        var index: Int = 0
        for ( index <- 0 to boxes.size() - 1) {
            var boxId = boxes.get(index).getId()
            var transactionId = getBoxTransactionId(boxes.get(index))
            var funderAddress = getBoxFunderAddress(transactionId)
            var boxValue = getBoxValue(boxes.get(index))
            var creationHeight = getCreationHeight(boxes.get(index))
            var settlementHeight = getSettlementHeight(boxes.get(index))
            println("Box Number:\t\t" + index)
            println("Box Id:\t\t\t" + boxId)
            println("Transaction Id:\t\t" + transactionId)
            println("Funder Address:\t\t" + funderAddress)
            println("Box Value:\t\t" + boxValue)
            println("Creation Height:\t" + creationHeight)
            println("Settlement Height:\t" + settlementHeight)
            println()
        }
    }
}