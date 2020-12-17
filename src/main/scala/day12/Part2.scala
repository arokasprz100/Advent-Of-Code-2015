package day12

import common.FileToStringReader

object Part2 extends App {
  val puzzleInput = JSONParser.processJsonString(FileToStringReader.read("src/main/scala/day12/input.txt"))
  val puzzleInputWithoutRedObjValues = JSONOperations.jsonToString(JSONOperations.removeObjectsWithRed(puzzleInput))
  val totalSum = "-?[0-9]+".r.findAllIn(puzzleInputWithoutRedObjValues).map(_.toInt).sum
  println(s"Total sum: $totalSum")
}
