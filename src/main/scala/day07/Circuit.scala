package day07

import day07.Extractors._
import day07.Operations._

object Circuit {

  val wires: scala.collection.mutable.Map[String, () => Int] = scala.collection.mutable.Map()

  def buildFrom(input: List[String]): Unit = {
    input.map(splitInstruction).foreach(instruction =>
      wires += (instruction._2 -> parseOperation(instruction._1, instruction._2))
    )
  }

  private def splitInstruction(instruction: String): (String, String) = {
    val parts = instruction.split("->")
    (parts(0).trim, parts(1).trim)
  }

  private def parseOperation(operation: String, destination: String): () => Int = operation match {
    case NegationOperationExtractor(rhs) => () => Negation(rhs)(destination)
    case BinaryOperationExtractor(lhs, rhs, operation) => () => BinaryOperation(lhs, rhs, operation)(destination)
    case x: String => () => Value(x)(destination)
  }

}
