package common

import scala.io.Source

object FileToLineListReader {

  def read(path: String): List[String] = {
    val bufferedSource = Source.fromFile(path)
    val content = bufferedSource.getLines.toList
    bufferedSource.close
    content
  }

}
