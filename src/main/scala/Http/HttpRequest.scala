package ergonames.Http

import ergonames.Http.HttpConfig._

import scalaj.http._
import spray.json._
import DefaultJsonProtocol._
import org.ergoplatform.appkit.NetworkType

object HttpRequest {

    def getData(url: String): String = {
        val response = Http(url).asString
        val body = response.body
        body
    }

    def convertHttpResponseToJSON(response: String): Map[String, Option[String]] = {
        val jsonData = response.parseJson
        val mappedData = jsonData.convertTo[Map[String, Option[String]]]
        mappedData
    }

    def parseJSONData(response: Map[String, Option[String]], key: String, error: String): String = {
        val data = response.getOrElse(key, error).toString()
        data
    }

}