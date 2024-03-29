package day18

import common.FileToLineListReader
import day18.automata.{GameOfLife, PartOneCellularAutomaton}


object Part1 extends App {
  val numberOfSteps = 100
  val puzzleInput = FileToLineListReader.read("src/main/scala/day18/input.txt")
  val ca = PartOneCellularAutomaton.fromInitialState(puzzleInput, GameOfLife.rules)
  ca.multipleSteps(numberOfSteps)
  println(s"After $numberOfSteps steps, there are ${ca.howManyLightsAreOn} lights that are on")
}
