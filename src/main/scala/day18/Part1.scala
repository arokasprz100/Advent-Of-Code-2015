package day18

import common.FileToLineListReader

class CellularAutomaton private (val board: Array[Array[Char]],
                                 val rules: (Char, Int) => Char) {

  def singleStep(): Unit = {
    val newBoard = Array.ofDim[Char](board.length, board(0).length)
    for {
      y <- board.indices
      x <- board(y).indices
    } newBoard(y)(x) = processSingleCell(x, y)
    copyBoardValues(newBoard)
  }

  def multipleSteps(numberOfSteps: Int): Unit = {
    (1 to numberOfSteps).foreach(_ => singleStep())
  }

  def howManyLightsAreOn: Int = {
    board.map(row => row.count(_ == '#')).sum
  }

  def processSingleCell(x: Int, y: Int): Char = {
    val neighbourCellValues = for {
      n_y <- -1 to 1
      n_x <- -1 to 1
    } yield if(n_y == 0 && n_x == 0) '.' else getCellValue(x + n_x, y + n_y)
    val numberOfActiveCells = neighbourCellValues.count(_ == '#')
    rules(getCellValue(x, y), numberOfActiveCells)
  }

  def getCellValue(x: Int, y: Int): Char = {
    if (x >= 0 && y >= 0 && x < board(0).length && y < board.length) board(y)(x)
    else '.'
  }

  override def toString: String = board.map(row => row.mkString).mkString("", "\n", "")

  private def copyBoardValues(newBoard: Array[Array[Char]]): Unit = {
    for {
      y <- newBoard.indices
      x <- newBoard(y).indices
    } board(y)(x) = newBoard(y)(x)
  }
}

object CellularAutomaton {

  def fromInitialState(state: List[String], rules: (Char, Int) => Char): CellularAutomaton = {
    val properRepresentation = state.map(row => row.toCharArray).toArray
    new CellularAutomaton(properRepresentation, rules)
  }
}


object Part1 extends App {

  def gameOfLifeRules(cellValue: Char, activeNeighbours: Int): Char = cellValue match {
    case '#' if activeNeighbours == 2 || activeNeighbours == 3 => '#'
    case '#' => '.'
    case '.' if activeNeighbours == 3 => '#'
    case x => x
  }


  val puzzleInput = FileToLineListReader.read("src/main/scala/day18/input.txt")
  val ca = CellularAutomaton.fromInitialState(puzzleInput, gameOfLifeRules)
  ca.multipleSteps(100)
  println(ca.toString)
  println(ca.howManyLightsAreOn)

}
