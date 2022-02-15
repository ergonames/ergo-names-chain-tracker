package ergonames.Http

import ergonames.Http.HttpConfig.testnetAPIUrl

import scalaj.http._

object HttpRequest {

    def getDataFromDatabase() {
        val url: String = testnetAPIUrl + "/ergonames/resolve/bob.ergo"
        val response = Http("https://testnet-api.ergonames.com/ergonames/resolve/bob.ergo").asString
        val data = response.body
        println(data)
    }
}