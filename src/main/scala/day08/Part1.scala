package day08

import common.FileToLineListReader

object Part1 extends App {

  val hexPattern = """(\\x)([0-9a-h]{2}).*""".r
  val quotePattern = """(\\").*""".r
  val backslashPattern = """(\\\\).*""".r

  def evaluateString(str: String): String = str match {
    case quotePattern(pattern) => "\"" + evaluateString(str.drop(pattern.length))
    case backslashPattern(pattern) => "\\" + evaluateString(str.drop(pattern.length))
    case hexPattern(hexStart, value) => Integer.parseInt(value, 16).toChar + evaluateString(str.drop(hexStart.length + value.length))
    case x if x.length > 0 => x.head + evaluateString(x.tail)
    case _ => ""
  }

  val input = FileToLineListReader.read("src/main/scala/day08/input.txt")
  val inputCharacters = input.map(_.length).sum
  val evaluatedInput = input.map(x => x.substring(1, x.length - 1)).map(evaluateString)
  val evaluatedInputCharacters = evaluatedInput.map(_.length).sum
  println(s"Difference: ${inputCharacters - evaluatedInputCharacters}")
}