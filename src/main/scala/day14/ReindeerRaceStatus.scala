package day14

class ReindeerRaceStatus private (val reindeer: Reindeer,
                                  val distance: Int,
                                  val counter: Int,
                                  val flying: Boolean) {

  override def toString: String = s"ReindeerRaceStatus($reindeer, $distance, $counter, $flying)"

}


object ReindeerRaceStatus {

  def withDefaultState(reindeer: Reindeer): ReindeerRaceStatus =
    new ReindeerRaceStatus(reindeer, 0, reindeer.flyTime, flying = true)

  def withStateAdvancedByOneSecond(status: ReindeerRaceStatus): ReindeerRaceStatus = {
    if(status.flying) {
      val distance = status.distance + status.reindeer.speed
      val counter = if(status.counter == 1) status.reindeer.restTime else status.counter - 1
      val flying = if(status.counter == 1) !status.flying else status.flying
      new ReindeerRaceStatus(status.reindeer, distance, counter, flying)
    } else {
      val counter = if(status.counter == 1) status.reindeer.flyTime else status.counter - 1
      val flying = if(status.counter == 1) !status.flying else status.flying
      new ReindeerRaceStatus(status.reindeer, status.distance, counter, flying)
    }
  }

}
