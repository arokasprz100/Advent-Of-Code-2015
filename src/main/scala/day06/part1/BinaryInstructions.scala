package day06.part1

import day06.common.Instruction

object BinaryInstructions {

  type BinaryGrid = Array[Array[Boolean]]

  trait BinaryInstruction extends Instruction {
    final override type Grid = BinaryGrid
  }

  object TurnOn extends BinaryInstruction {
    override val instructionStr: String = "turn on "
    override def onSingleLight(x: Int, y: Int, grid: BinaryGrid): Unit = grid(x)(y) = true
  }

  object TurnOff extends BinaryInstruction {
    override val instructionStr: String = "turn off "
    override def onSingleLight(x: Int, y: Int, grid: BinaryGrid): Unit = grid(x)(y) = false
  }

  object Toggle extends BinaryInstruction {
    override val instructionStr: String = "toggle "
    override def onSingleLight(x: Int, y: Int, grid: BinaryGrid): Unit = grid(x)(y) = !grid(x)(y)
  }

}
