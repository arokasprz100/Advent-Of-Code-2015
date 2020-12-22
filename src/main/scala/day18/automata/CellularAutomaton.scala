package day18.automata

trait CellularAutomaton {

  val board: Array[Array[Char]]

  def processSingleCell(x: Int, y: Int): Char

  def multipleSteps(numberOfSteps: Int): Unit = (1 to numberOfSteps).foreach(_ => singleStep())

  override def toString: String = board.map(row => row.mkString).mkString("", "\n", "")


  def getCellValue(x: Int, y: Int): Char = board(y)(x)

  def countNeighboursWithGivenState(neighboursIndexes: IndexedSeq[(Int, Int)], state: Char): Int = {
    val neighbourCellValues = neighboursIndexes.map(elem => getCellValue(elem._1, elem._2))
    neighbourCellValues.count(_ == state)
  }


  private def singleStep(): Unit = {
    val newBoard = Array.ofDim[Char](board.length, board(0).length)
    for {
      y <- board.indices
      x <- board(y).indices
    } newBoard(y)(x) = processSingleCell(x, y)
    copyBoardValues(newBoard)
  }

  private def copyBoardValues(newBoard: Array[Array[Char]]): Unit = {
    for {
      y <- newBoard.indices
      x <- newBoard(y).indices
    } board(y)(x) = newBoard(y)(x)
  }

}
