package day13

import common.FileToLineListReader
import SeatingArrangement._

object Part1 extends App {
  val guestList = FileToLineListReader.read("src/main/scala/day13/input.txt").flatMap(parseGuestListEntry).toMap
  val guests = guestList.keys.map(x => x._1).toList.distinct
  val maxPossibleHappiness = guests.permutations.map(evaluateHappinessInArrangement(_, guestList)).max
  println(s"Total change of happiness in the optimal seating: $maxPossibleHappiness")
}