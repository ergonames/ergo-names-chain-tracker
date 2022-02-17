package ergonames

import ergonames.Database.TokenUtils._

object Main{

  def main(args: Array[String]): Unit = {
    println("Ergo Names Backend\n")

    val tokenName = "bob.ergohhyh"
    val isRegistered = checkAlreadyRegistered(tokenName)
    if (isRegistered) {
      println("Already Registered")
    } else {
      println("Not Registered")
    }
  }

}