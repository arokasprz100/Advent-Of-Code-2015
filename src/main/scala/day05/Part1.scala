package day05

import common.FileToLineListReader

object Part1 extends App {

  object NiceString {
    val vowels = "aeiou"
    val forbidden = List("ab", "cd", "pq", "xy")

    def validateString(str: String): Boolean =
      str.count(c => vowels.contains(c)) >= 3 &&
      "(.)\\1+".r.findAllIn(str).nonEmpty &&
      forbidden.forall(str.contains(_) == false)

    def unapply(str: String): Option[String] = Some(str).filter(validateString)
  }

  val input = FileToLineListReader.read("src/main/scala/day05/input.txt")
  println(s"Number of nice strings: ${input.collect{ case NiceString(str) => str }.size}")
}
