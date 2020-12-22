package day18.automata

final class PartOneCellularAutomaton private (val board: Array[Array[Char]], val rules: (Char, Int) => Char)
  extends AdventOfCodeCellularAutomaton {

  override def processSingleCell(x: Int, y: Int): Char = applyRulesOnSingleCell(x, y)

}


object PartOneCellularAutomaton {

  def fromInitialState(state: List[String], rules: (Char, Int) => Char): PartOneCellularAutomaton = {
    val properRepresentation = state.map(row => row.toCharArray).toArray
    new PartOneCellularAutomaton(properRepresentation, rules)
  }

}
