package day18.automata

final class PartTwoCellularAutomaton private (val board: Array[Array[Char]], val rules: (Char, Int) => Char)
  extends AdventOfCodeCellularAutomaton {

  override def processSingleCell(x: Int, y: Int): Char = {
    if(isCornerCell(x, y)) getCellValue(x, y)
    else applyRulesOnSingleCell(x, y)
  }

  private def isCornerCell(x: Int, y: Int): Boolean =
    (x == 0 && y == 0) || (x == 0 && y == board.length - 1) ||
      (x == board(0).length - 1 && y == 0) || (x == board(0).length - 1 && y == board.length - 1)

}


object PartTwoCellularAutomaton {

  def fromInitialState(state: List[String], rules: (Char, Int) => Char): PartTwoCellularAutomaton = {
    val properRepresentation = state.map(row => row.toCharArray).toArray
    setCornetValues(properRepresentation)
    new PartTwoCellularAutomaton(properRepresentation, rules)
  }

  private def setCornetValues(board: Array[Array[Char]]): Unit = {
    board(0)(0) = '#'
    board(0)(board(0).length - 1) = '#'
    board(board.length - 1)(0) = '#'
    board(board.length - 1)(board(0).length - 1) = '#'
  }

}