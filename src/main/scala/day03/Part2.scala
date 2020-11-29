package day03

import day03.UniquePositionsEvaluator._
import common.FileToStringReader

object Part2 extends App {
  val input = FileToStringReader.read("src/main/scala/day03/input.txt")
  val visitedBySanta = getUniquePositions(input, (0, 0), Set(), str => str.drop(2))
  val visitedByRoboSanta = getUniquePositions(input.tail, (0, 0), Set(), str => str.drop(2))
  println(s"Total number of unique positions: ${(visitedByRoboSanta ++ visitedBySanta).size}")
}
