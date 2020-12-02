package day11

import common.FileToStringReader
import PasswordGenerator.generateNewPassword

object Solution extends App {
  val input = FileToStringReader.read("src/main/scala/day11/input.txt")
  println(s"Old password: $input")

  val firstNewPassword = generateNewPassword(input)
  println(s"First new password: $firstNewPassword")

  val secondNewPassword = generateNewPassword(firstNewPassword)
  println(s"Second new password: $secondNewPassword")
}
