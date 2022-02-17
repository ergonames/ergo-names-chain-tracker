package ergonames

import ergonames.Box.BoxScanner._

object Main{

  def main(args: Array[String]): Unit = {
    println("Ergo Names Backend\n")

    val boxes = scanBox()
    var a = 0
    for ( a <- 0 to boxes.size() - 1) {
      println(boxes.get(a))
    }
  }

}