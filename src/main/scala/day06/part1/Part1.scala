package day06.part1

import BinaryInstructions._
import common.FileToLineListReader

object Part1 extends App {

  def executeBinaryInstruction(str: String, grid: BinaryGrid): Unit = str match {
    case TurnOn(startCoords, endCoords) => TurnOn.onLightsRange(grid, startCoords, endCoords)
    case TurnOff(startCoords, endCoords) => TurnOff.onLightsRange(grid, startCoords, endCoords)
    case Toggle(startCoords, endCoords) => Toggle.onLightsRange(grid, startCoords, endCoords)
  }

  val input = FileToLineListReader.read("src/main/scala/day06/input.txt")
  val grid = Array.ofDim[Boolean](1000, 1000)
  input.foreach(executeBinaryInstruction(_, grid))
  println(s"Number of lights that are switched on: ${grid.flatten.count(_ == true)}")
}
