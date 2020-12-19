package day14

import common.FileToLineListReader


object Part1 extends App {
  val puzzleInput = FileToLineListReader.read("src/main/scala/day14/input.txt")
  val reindeer = puzzleInput.map(ReindeerParser.parseReindeer)
  val reindeerInRace = reindeer.map(ReindeerRaceStatus.withDefaultState)
  val reindeerAfterRace = ReindeerRace.advance(reindeerInRace, 2503, (_: List[ReindeerRaceStatus]) => ())
  val winningReindeer = reindeerAfterRace.maxBy(reindeer => reindeer.distance)
  println(s"Winning reindeer ${winningReindeer.reindeer.name} traveled ${winningReindeer.distance} km")
}
