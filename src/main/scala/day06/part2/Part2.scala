package day06.part2

import common.FileToLineListReader
import IntegerInstructions._

object Part2 extends App {

  def executeIntegerInstruction(str: String, grid: IntegerGrid): Unit = str match {
    case IncreaseBrightnessByOne(startCoords, endCoords) => IncreaseBrightnessByOne.onLightsRange(grid, startCoords, endCoords)
    case DecreaseBrightnessByOne(startCoords, endCoords) => DecreaseBrightnessByOne.onLightsRange(grid, startCoords, endCoords)
    case IncreaseBrightnessByTwo(startCoords, endCoords) => IncreaseBrightnessByTwo.onLightsRange(grid, startCoords, endCoords)
  }

  val input = FileToLineListReader.read("src/main/scala/day06/input.txt")
  val grid = Array.ofDim[Int](1000, 1000)
  input.foreach(executeIntegerInstruction(_, grid))
  println(s"Total brightness: ${grid.flatten.sum}")
}
