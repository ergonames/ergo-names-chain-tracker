package ergonames

import ergonames.Box.BoxScanner._

object Main{

  def main(args: Array[String]): Unit = {
    println("Ergo Names Backend\n")

    val boxes = scanBox()
    println(boxes)
  }

}