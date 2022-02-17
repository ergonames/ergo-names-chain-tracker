package ergonames.Box

import org.ergoplatform.appkit.InputBox

object BoxUtils {

    def printBoxesFromList(boxes: java.util.List[InputBox]) {
        var index: Int = 0
        for ( index <- 0 to boxes.size() - 1) {
            println(boxes.get(index))
        }
    }
}