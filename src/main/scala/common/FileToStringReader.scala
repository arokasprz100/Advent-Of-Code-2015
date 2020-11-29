package common

import scala.io.Source

object FileToStringReader {

  def read(path: String): String = {
    val bufferedSource = Source.fromFile(path)
    val content = bufferedSource.getLines.mkString
    bufferedSource.close
    content
  }
}
