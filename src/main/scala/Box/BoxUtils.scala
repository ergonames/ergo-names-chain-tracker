package ergonames.Box

import ergonames.Http.HttpRequest._
import ergonames.Http.HttpConfig.ergoTestnetAPIUrl
import ergonames.Utils.StringUtils._

import scalaj.http._
import org.ergoplatform.appkit.InputBox
import spray.json._
import DefaultJsonProtocol._
import scala.collection.mutable.ListBuffer

object BoxUtils {

    def printBoxesFromList(boxesList: ListBuffer[Box]) {
        var index: Int = 0
        for ( index <- 0 to boxesList.length - 1) {
            var box = boxesList(index)
            box.initializeBox()
            println("Box Number:\t\t" + index)
            println("Box Id:\t\t\t" + box.getId())
            println("Transaction Id:\t\t" + box.getTransactionId())
            println("Funder Address:\t\t" + box.getFunderAddress())
            println("Box Value:\t\t" + box.getValue())
            println("Creation Height:\t" + box.getCreationHeight())
            println("Settlement Height:\t" + box.getSettlementHeight())
            println()
        }
    }

    def parseBoxJson(json: JsObject, key: String): String = {
        val data = json.getFields(key)(0).toString()
        data
    }
}