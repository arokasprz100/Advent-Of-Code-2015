package day12

import scala.annotation.tailrec

object JSONParserHelpers {

  def splitOnComas(str: String): List[String] = {
    val indexes = findIndexesToSplit(str, List(), 0, 0)
    val substrings = indexes.foldLeft((List[String](), 0))(
      (x, elem) => (x._1 :+ str.substring(x._2, elem).trim, elem + 1)
    )._1
    if(indexes.nonEmpty) substrings :+ str.substring(indexes.last + 1).trim else if (str.nonEmpty) List(str.trim) else List()
  }

  @tailrec
  def findIndexesToSplit(str: String, indexes: List[Int], counter: Int, index: Int): List[Int] = {
    if(str.isEmpty) indexes
    else {
      val newCounter =
        if(str.head == '}' || str.head == ']') counter + 1
        else if(str.head == '{' || str.head == '[') counter - 1
        else counter
      val newIndexes = if(newCounter == 0 && str.head == ',') indexes :+ index else indexes
      findIndexesToSplit(str.tail, newIndexes, newCounter, index + 1)
    }
  }

  def removeBorders(str: String): String = str.substring(1, str.length - 1)


}
