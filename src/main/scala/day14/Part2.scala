package day14

import common.FileToLineListReader


object Part2 extends App {
  val puzzleInput = FileToLineListReader.read("src/main/scala/day14/input.txt")
  val reindeer = puzzleInput.map(ReindeerParser.parseReindeer)
  val reindeerInRace = reindeer.map(ReindeerRaceStatus.withDefaultState)
  val reindeerAfterRace = ReindeerRace.advance(reindeerInRace, 2503, ReindeerJudge.updateScores)
  val winningScore = ReindeerJudge.getWinningScore
  println(s"The winning reindeer has $winningScore points")
}
