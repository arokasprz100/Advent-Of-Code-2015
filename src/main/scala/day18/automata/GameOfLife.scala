package day18.automata

object GameOfLife {

  def rules(cellValue: Char, activeNeighbours: Int): Char = cellValue match {
    case '#' if activeNeighbours == 2 || activeNeighbours == 3 => '#'
    case '#' => '.'
    case '.' if activeNeighbours == 3 => '#'
    case x => x
  }

}
