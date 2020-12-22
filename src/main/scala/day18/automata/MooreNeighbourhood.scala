package day18.automata

trait MooreNeighbourhood {

  val board: Array[Array[Char]]

  def getNeighboursIndexes(x: Int, y: Int): IndexedSeq[(Int, Int)] = {
    for {
      n_y <- -1 to 1
      n_x <- -1 to 1
      if !(n_y == 0 && n_x == 0)
    } yield (x + n_x, y + n_y)
  }

  def filterOutIndexesOutsideBoard(indexes: IndexedSeq[(Int, Int)]): IndexedSeq[(Int, Int)] =
    indexes.filter(elem => elem._1 >= 0 && elem._1 < board(0).length && elem._2 >= 0 && elem._2 < board.length)

}
