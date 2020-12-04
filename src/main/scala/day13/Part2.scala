package day13

import common.FileToLineListReader
import day13.SeatingArrangement._

object Part2 extends App {
  val guestList = FileToLineListReader.read("src/main/scala/day13/input.txt").flatMap(parseGuestListEntry).toMap
  val guests = guestList.keys.map(x => x._1).toList.distinct
  val myHappiness = guests.flatMap(guest => Map(("me", guest) -> 0, (guest, "me") -> 0)).toMap
  val improvedGuestList = guestList ++ myHappiness
  val maxPossibleHappiness = (guests :+ "me").permutations.map(evaluateHappinessInArrangement(_, improvedGuestList)).max
  println(s"Total change of happiness in the optimal seating: $maxPossibleHappiness")
}
