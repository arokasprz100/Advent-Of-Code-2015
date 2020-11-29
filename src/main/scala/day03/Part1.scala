package day03

import common.FileToStringReader
import UniquePositionsEvaluator._

object Part1 extends App {
  val input = FileToStringReader.read("src/main/scala/day03/input.txt")
  print(s"Number of unique positions: ${getUniquePositions(input, (0, 0), Set(), str => str.tail).size}")
}
