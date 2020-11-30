package day08

import common.FileToLineListReader

object Part2 extends App {

  val quotePattern = """(").*""".r
  val backslashPattern = """(\\).*""".r
  val hexPattern = """(\\x).*""".r

  def encodeString(str: String): String = str match {
    case quotePattern(pattern) => "\\\"" + encodeString(str.drop(pattern.length))
    case backslashPattern(pattern) => "\\\\" + encodeString(str.drop(pattern.length))
    case hexPattern(pattern) => "\\\\x" + encodeString(str.drop(pattern.length))
    case x if x.length > 0 => x.head + encodeString(x.tail)
    case _ => ""
  }

  val input = FileToLineListReader.read("src/main/scala/day08/input.txt")
  val inputCharacters = input.map(_.length).sum
  val encodedInput = input.map(encodeString).map(x => "\"" + x + "\"")
  val encodedInputCharacters = encodedInput.map(_.length).sum
  println(s"Difference: ${encodedInputCharacters - inputCharacters}")
}
