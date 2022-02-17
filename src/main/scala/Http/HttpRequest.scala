package ergonames.Http

import ergonames.Http.HttpConfig.testnetAPIUrl

import scalaj.http._
import spray.json._
import DefaultJsonProtocol._

object HttpRequest {

    def getDataFromDatabase(ergoName: String): String = {
        val url: String = testnetAPIUrl + "/ergonames/resolve/" + ergoName
        val response = Http(url).asString
        val data = response.body
        data
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