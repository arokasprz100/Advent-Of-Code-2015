package day01

import common.FileToStringReader

object Part1 extends App {
  val input = FileToStringReader.read("src/main/scala/day01/input.txt")
  val finalFloor = input.collect({
    case '(' => 1
    case ')' => -1
  }).sum
  println(s"The final floor is $finalFloor")
}