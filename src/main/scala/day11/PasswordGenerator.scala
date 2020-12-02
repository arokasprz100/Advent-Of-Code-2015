package day11

import day11.PasswordValidators.fulfillsAllConditions
import scala.annotation.tailrec

object PasswordGenerator {

  @tailrec
  def generateNewPassword(oldPassword: String): String = {
    val passwordCandidate = incrementString(oldPassword)
    if(fulfillsAllConditions(passwordCandidate)) passwordCandidate
    else generateNewPassword(passwordCandidate)
  }

  def incrementString(str: String): String = str.lastOption match {
    case Some('z') =>s"${incrementString(str.init)}a"
    case Some(x) => s"${str.init}${(x + 1).toChar}"
    case None => "" // it is not clear what should be done in this case
  }

}
