package day14

import scala.annotation.tailrec

object ReindeerRace {

  @tailrec
  final def advance(reindeer: List[ReindeerRaceStatus], seconds: Int,
                    resultMonitoring: List[ReindeerRaceStatus] => Unit): List[ReindeerRaceStatus] = {
    seconds match {
      case 0 => reindeer
      case _ =>
        val updatedReindeer = reindeer.map(ReindeerRaceStatus.withStateAdvancedByOneSecond)
        resultMonitoring(updatedReindeer)
        advance(updatedReindeer, seconds - 1, resultMonitoring)
    }
  }

}