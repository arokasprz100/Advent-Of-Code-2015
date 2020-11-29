package day04

import java.security.MessageDigest
import common.FileToStringReader
import common.TimeMeasurement._
import scala.annotation.tailrec

object Solution extends App {

  @tailrec
  def findProperInput(number: Int, key: String, endingCondition: String): Int = {
    val hashValue = MessageDigest.getInstance("MD5").digest(s"$key$number".getBytes)
      .take(Math.ceil(endingCondition.length / 2.0).toInt).map(b => String.format("%02x", b)).mkString
    if(hashValue.startsWith(endingCondition)) number
    else findProperInput(number + 1, key, endingCondition)
  }


  val input = FileToStringReader.read("src/main/scala/day04/input.txt")
  timeMeasurement{ println(s"First part: ${findProperInput(1, input, "00000")}") }
  timeMeasurement{ println(s"Second part: ${findProperInput(1, input, "000000")}") }

}
