package day07

import BitwiseOperations16Bit._

object Operations {

  trait Memoization {
    final def memoize(code: => Int)(destination: String): Int = {
      val result = code
      Circuit.wires(destination) = () => result
      result
    }
  }

  abstract class Operation extends Memoization {
    protected val operationApplication: () => Int

    private final def isNumber(str: String) = str.forall(_.isDigit)
    final def processArgument(str: String): Int = if(isNumber(str)) str.toInt else Circuit.wires(str)()
    final def apply(destination: String): Int = memoize(operationApplication())(destination)
  }

  case class Negation(rhs: String) extends Operation {
    override val operationApplication: () => Int = () => not(processArgument(rhs))
  }

  case class BinaryOperation(lhs: String, rhs: String, operator: (Int, Int) => Int) extends Operation {
    override val operationApplication: () => Int = () => operator(processArgument(lhs), processArgument(rhs))
  }

  case class Value(value: String) extends Operation {
    override val operationApplication: () => Int = () => processArgument(value)
  }

}
