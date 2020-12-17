package day12

import common.FileToStringReader

object Part1 extends App {
  val puzzleInput = FileToStringReader.read("src/main/scala/day12/input.txt")
  val totalSum = "-?[0-9]+".r.findAllIn(puzzleInput).map(_.toInt).sum
  println(s"Total sum: $totalSum")
}
