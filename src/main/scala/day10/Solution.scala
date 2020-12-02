package day10

import common.FileToStringReader

import scala.annotation.tailrec

object Solution extends App {

  def lookAndSay(str: String): String = "((.)\\2*)".r.replaceAllIn(str, m => s"${m.group(1).length}${m.group(2)}")

  @tailrec
  def applyNTimes(fun: String => String, input: String, numberOfTimes: Int): String = numberOfTimes match {
    case x if x < 1 => input
    case x => applyNTimes(fun, fun(input), x - 1)
  }

  val input = FileToStringReader.read("src/main/scala/day10/input.txt")
  println(s"Part 1: ${applyNTimes(lookAndSay, input, 40).length}")
  println(s"Part 2: ${applyNTimes(lookAndSay, input, 50).length}")
}
