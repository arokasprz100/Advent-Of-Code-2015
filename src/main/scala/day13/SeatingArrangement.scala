package day13

object SeatingArrangement {

  def parseGuestListEntry(str: String): Map[(String, String), Int] = {
    val parts = str.split(" ").map(_.trim)
    val guests = (parts.head, parts.last.init)
    val changeInHappiness = if(parts(2) == "gain") parts(3).toInt else -parts(3).toInt
    Map(guests -> changeInHappiness)
  }

  def evaluateHappinessInArrangement(l: List[String], guestList: Map[(String, String), Int]): Int = {
    val happinessFromLeftToRight = (l :+ l.head).tail.foldLeft((0, l.head))((prev, person) => {
      (prev._1 + guestList(prev._2, person), person)
    })._1
    val happinessFromRightToLeft = (l.last +: l).init.foldRight((0, l.last))((person, prev) => {
      (prev._1 + guestList(prev._2, person), person)
    })._1
    happinessFromLeftToRight + happinessFromRightToLeft
  }

}
