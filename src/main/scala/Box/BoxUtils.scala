package ergonames.Box

import ergonames.Http.HttpConfig.ergoTestnetAPIUrl

import scalaj.http._
import spray.json._
import DefaultJsonProtocol._
import org.ergoplatform.appkit.InputBox

object BoxUtils {

    def getBoxFunderAddress(transactionId: String): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/transactions/" + transactionId
        val response = Http(url).asString
        val transactionData = response.body
        //println(transactionData)
        "ss"
    }

    def getBoxTransactionId(box: InputBox): String = {
        val url: String = ergoTestnetAPIUrl + "/api/v1/boxes/" + box.getId()
        val response = Http(url).asString
        val boxData = response.body
        println(boxData)

        // val jsonData = boxData.parseJson
        // val mappedData = jsonData.convertTo[Map[String, Option[String]]]
        // println(mappedData("transactionId"))

        val substr1 = boxData.split("transactionId")(1)
        val substr2 = substr1.substring(3, substr1.size - 1)
        val substr3 = substr2.split(",")(0)
        val substr4 = substr3.substring(0, substr3.size - 1)
        substr4
    }

    def printBoxesFromList(boxes: java.util.List[InputBox]) {
        var index: Int = 0
        for ( index <- 0 to boxes.size() - 1) {
            //println(boxes.get(index))
            println("Box Id:\t\t\t" + boxes.get(index).getId())
            println("Transaction Id:\t\t" + getBoxTransactionId(boxes.get(index)))
            println("Funder Address:\t\t" + getBoxFunderAddress(getBoxFunderAddress("s")))
            println()
        }
    }
}