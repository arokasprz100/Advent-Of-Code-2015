package day03

import scala.annotation.tailrec

object UniquePositionsEvaluator {

  @tailrec
  def getUniquePositions(str: String, pos: (Int, Int), visited: Set[(Int, Int)], nextStringStrategy: String => String): Set[(Int, Int)] = str match {
    case MovementExtractor(move) => getUniquePositions(nextStringStrategy(str), (pos._1 + move._1, pos._2 + move._2), visited + pos, nextStringStrategy)
    case _ => visited + pos
  }

}
