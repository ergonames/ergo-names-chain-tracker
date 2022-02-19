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
        val boxData = response.body
        val boxAST = boxData.parseJson
        val boxJson = boxAST.asJsObject
        val transactionInputs = boxJson.getFields("inputs")
        val txInputsString = transactionInputs.toString()
        val txInputsJson = txInputsString.parseJson
        val txInputsAST = txInputsJson.asJsObject
        val address = txInputsAST.getFields("address")
        println(address(0))
        val funderAddress = "ss"
        funderAddress
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
            println("Funder Address:\t\t" + getBoxFunderAddress(getBoxFunderAddress(getBoxTransactionId(boxes.get(index)))))
            println()
        }
    }
}