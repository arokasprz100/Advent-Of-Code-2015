package day07

import common.FileToLineListReader

object Solution extends App {
  val input = FileToLineListReader.read("src/main/scala/day07/input.txt")
  Circuit.buildFrom(input)
  val wireAValue = Circuit.wires("a")()
  println(s"Part 1: value in wire a: $wireAValue")

  Circuit.wires.clear()
  Circuit.buildFrom(input)
  Circuit.wires("b") = () => wireAValue
  println(s"Part 2: value in wire a: ${Circuit.wires("a")()}")
}
