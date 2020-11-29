package day06.common

import Types.Coords

trait Instruction {

  type Grid
  val instructionStr: String

  def onSingleLight(x: Int, y: Int, grid: Grid): Unit

  final def onLightsRange(grid: Grid, start: Coords, end: Coords): Unit = {
    for (x <- start._1 to end._1; y <- start._2 to end._2) {
      onSingleLight(x, y, grid)
    }
  }

  final def unapply(str: String): Option[(Coords, Coords)] = {
    if (str.startsWith(instructionStr)) Some(SantaInstructionParser.getCoordinates(str.drop(instructionStr.length)))
    else None
  }
}
