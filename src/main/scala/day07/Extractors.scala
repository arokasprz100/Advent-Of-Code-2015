package day07

import day07.BitwiseOperations16Bit._

object Extractors {

  object NegationOperationExtractor {
    def unapply(str: String): Option[String] = {
      if(str.startsWith("NOT")) Some(str.drop(3).trim)
      else None
    }
  }

  object BinaryOperationExtractor {

    private def splitBinaryOperation(str: String): (String, String, String) = {
      val parts = str.split(" ")
      (parts(1), parts(0), parts(2))
    }

    def unapply(str: String): Option[(String, String, (Int, Int) => Int)] = {
      if(List("AND", "OR", "LSHIFT", "RSHIFT").exists(str.contains(_))) {
        val (operator, lhs, rhs) = splitBinaryOperation(str)
        operator match {
          case "AND" => Some((lhs, rhs, and))
          case "OR" => Some((lhs, rhs, or))
          case "LSHIFT" => Some((lhs, rhs, leftShift))
          case "RSHIFT" => Some((lhs, rhs, rightShift))
          case _ => None
        }
      } else None
    }
  }


}
