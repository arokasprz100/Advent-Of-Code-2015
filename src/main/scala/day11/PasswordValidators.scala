package day11

import scala.annotation.tailrec

object PasswordValidators {

  def fulfillsAllConditions(password: String): Boolean =
    containsNoForbiddenLetters(password) &&
      containsIncreasingSequence(password) &&
      containsTwoDifferentPairsOfLetters(password)


  def containsNoForbiddenLetters(password: String): Boolean =
    !password.exists("iol".toSet)


  def containsTwoDifferentPairsOfLetters(password: String): Boolean =
    "((.)\\2+)".r.findAllIn(password).map(_.head).toSet.size > 1


  def containsIncreasingSequence(password: String): Boolean = {

    @tailrec
    def containsIncreasingSequenceImpl(previous: Char, str: String, counter: Int): Boolean = {
      if(counter == 3) true
      else if(str.isEmpty) false
      else {
        val newCounter = if(str.head - previous == 1) counter + 1 else 1
        containsIncreasingSequenceImpl(str.head, str.tail, newCounter)
      }
    }
    containsIncreasingSequenceImpl(password.head, password.tail, 1)
  }

}
