package ergonames.Http

import ergonames.Http.HttpConfig.testnetAPIUrl

import scalaj.http._

object HttpRequest {

    def getDataFromDatabase(ergoName: String) {
        val url: String = testnetAPIUrl + "/ergonames/resolve/" + ergoName
        val response = Http(url).asString
        val data = response.body
        println(data)
    }

}