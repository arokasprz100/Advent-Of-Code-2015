package day05

import common.FileToLineListReader

object Part2 extends App {

  object NiceString {

    def containsTwoLettersThatAppearTwiceWithoutOverlapping(str: String): Boolean =
      "(.{2}).*\\1".r.findAllIn(str).nonEmpty

    def containsLetterWhichRepeatsWithOneLetterBetweenThem(str: String): Boolean = {
      "(.).\\1".r.findAllIn(str).nonEmpty
    }

    def unapply(str: String): Option[String] = {
      if(containsTwoLettersThatAppearTwiceWithoutOverlapping(str) &&
        containsLetterWhichRepeatsWithOneLetterBetweenThem(str)) Some(str)
      else None
    }

  }

  val input = FileToLineListReader.read("src/main/scala/day05/input.txt")
  println(s"Number of nice strings: ${input.collect({ case NiceString(str) => str }).size}")
}
