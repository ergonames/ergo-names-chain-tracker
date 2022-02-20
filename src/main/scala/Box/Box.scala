package ergonames.Box

import ergonames.Http.HttpRequest._
import ergonames.Http.HttpConfig.ergoTestnetAPIUrl
import ergonames.Utils.StringUtils._
import ergonames.Box.BoxUtils.parseBoxJson

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
    private var boxAPIData: String = ""

    def initializeBox() {
        id = iBox.getId().toString()
        setBoxAPIData()
        setBoxTransactionId()
        setBoxFunderAddress()
        setBoxValue()
        setCreationHeight()
        setSettlementHeight()
    }

    private def setBoxAPIData() = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + id
        boxAPIData = getData(url)        
    }

    def getId(): String = {
        id
    }

    def setBoxTransactionId() {
        val boxJson = convertStringToJsObject(boxAPIData)
        val transactionIdRaw = parseBoxJson(boxJson, "transactionId")
        transactionId = removeFirstAndLastCharacter(transactionIdRaw)
    }

    def getTransactionId(): String = {
        transactionId
    }

    def setBoxFunderAddress() {
        val url: String = ergoTestnetAPIUrl + "/api/v1/transactions/" + transactionId
        val transactionData = getData(url)
        val transactionJson = convertStringToJsObject(transactionData)
        val inputsData = parseBoxJson(transactionJson, "inputs")
        val adjustedInputsData = removeFirstAndLastCharacter(inputsData)
        val addressJson = convertStringToJsObject(adjustedInputsData)
        val address = parseBoxJson(addressJson, "address")
        val adjustedAddress = removeFirstAndLastCharacter(address)
        funderAddress = adjustedAddress
    }

    def getFunderAddress(): String = {
        funderAddress
    }

    def setBoxValue() {
        val boxJson = convertStringToJsObject(boxAPIData)
        val value = parseBoxJson(boxJson, "value")
        boxValue = value
    }

    def getValue(): String = {
        boxValue
    }

    def setCreationHeight() {
        val boxJson = convertStringToJsObject(boxAPIData)
        creationHeight = parseBoxJson(boxJson, "creationHeight")
    }

    def getCreationHeight(): String = {
        creationHeight
    }

    def setSettlementHeight() {
        val boxJson = convertStringToJsObject(boxAPIData)
        settlementHeight = parseBoxJson(boxJson, "settlementHeight")
    }

    def getSettlementHeight(): String = {
        settlementHeight
    }

}