package day18.automata

trait AdventOfCodeCellularAutomaton extends CellularAutomaton with MooreNeighbourhood {

  val rules: (Char, Int) => Char

  protected final def applyRulesOnSingleCell(x: Int, y: Int): Char = {
    val neighboursIndexes = filterOutIndexesOutsideBoard(getNeighboursIndexes(x, y))
    val numberOfActiveCells = countNeighboursWithGivenState(neighboursIndexes, '#')
    rules(getCellValue(x, y), numberOfActiveCells)
  }

  final def howManyLightsAreOn: Int = board.map(row => row.count(_ == '#')).sum

}
