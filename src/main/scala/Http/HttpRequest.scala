package ergonames.Http

import ergonames.Http.HttpConfig.testnetAPIUrl

import scalaj.http._

object HttpRequest {

    def getDataFromDatabase() {
        val url: String = testnetAPIUrl + "/ergonames/resolve/bob.ergo"
        val response = Http(url).asString
        val data = response.body
        println(data)
    }
}