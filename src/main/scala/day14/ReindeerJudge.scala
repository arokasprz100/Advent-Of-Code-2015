package day14

import scala.collection.mutable

object ReindeerJudge {

  private val reindeerScores = mutable.Map[String, Int]()

  def updateScores(reindeer: List[ReindeerRaceStatus]): Unit = {
    val winningDistance = reindeer.maxBy(r => r.distance).distance
    for(winningReindeer <- reindeer.filter(r => r.distance == winningDistance)) {
      reindeerScores(winningReindeer.reindeer.name) = reindeerScores.getOrElse(winningReindeer.reindeer.name, 0) + 1
    }
  }

  def getWinningScore: Int = reindeerScores.maxBy(_._2)._2

}