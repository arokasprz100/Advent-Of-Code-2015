package day06.part2

import day06.common.Instruction

object IntegerInstructions {

  type IntegerGrid = Array[Array[Int]]

  trait IntegerInstruction extends Instruction {
    final override type Grid = IntegerGrid
  }

  object IncreaseBrightnessByOne extends IntegerInstruction {
    override val instructionStr: String = "turn on "
    override def onSingleLight(x: Int, y: Int, grid: IntegerGrid): Unit = {
      grid(x)(y) = grid(x)(y) + 1
    }
  }

  object DecreaseBrightnessByOne extends IntegerInstruction {
    override val instructionStr: String = "turn off "
    override def onSingleLight(x: Int, y: Int, grid: IntegerGrid): Unit = {
      grid(x)(y) = if (grid(x)(y) > 0) grid(x)(y) - 1 else 0
    }
  }

  object IncreaseBrightnessByTwo extends IntegerInstruction {
    override val instructionStr: String = "toggle "
    override def onSingleLight(x: Int, y: Int, grid: IntegerGrid): Unit = {
      grid(x)(y) = grid(x)(y) + 2
    }
  }

}
