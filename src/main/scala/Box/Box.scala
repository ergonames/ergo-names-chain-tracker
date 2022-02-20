package ergonames.Box

import ergonames.Http.HttpRequest._
import ergonames.Http.HttpConfig.ergoTestnetAPIUrl
import ergonames.SystemUtils.StringUtils._

import scalaj.http._
import spray.json._
import DefaultJsonProtocol._

import org.ergoplatform.appkit.InputBox

class Box(iBox: InputBox) {

    var id: String = ""
    var transactionId: String = ""
    var funderAddress: String = ""
    var boxValue: String = ""
    var creationHeight: String = ""
    var settlementHeight: String = ""

    def initializeBox() {
        id = iBox.getId().toString()
        transactionId = setBoxTransactionId()
        funderAddress = setBoxFunderAddress()
        boxValue = setBoxValue()
        creationHeight = setCreationHeight()
        settlementHeight = setSettlementHeight()
    }

    def getId(): String = {
        id
    }

    def getTransactionId(): String = {
        transactionId
    }

    def getFunderAddress(): String = {
        funderAddress
    }

    def getValue(): String = {
        boxValue
    }

    def getCreationHeight(): String = {
        creationHeight
    }

    def getSettlementHeight(): String = {
        settlementHeight
    }

    def setBoxFunderAddress(): String = {
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

    def setBoxTransactionId(): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + id
        val boxData = getData(url)
        val boxJson = convertStringToJsObject(boxData)
        val transactionIdRaw = boxJson.getFields("transactionId")(0).toString()
        val transactionId = removeFirstAndLastCharacter(transactionIdRaw)
        transactionId
    }

    def setBoxValue(): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + id
        val boxData = getData(url)
        val boxJson = convertStringToJsObject(boxData)
        val value = boxJson.getFields("value")(0).toString()
        value
    }

    def setCreationHeight(): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + id
        val boxData = getData(url)
        val boxJson = convertStringToJsObject(boxData)
        val creationHeight = boxJson.getFields("creationHeight")(0).toString()
        creationHeight
    }

    def setSettlementHeight(): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + id
        val boxData = getData(url)
        val boxJson = convertStringToJsObject(boxData)
        val settlementHeight = boxJson.getFields("settlementHeight")(0).toString()
        settlementHeight
    }

}