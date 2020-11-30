package day07

object BitwiseOperations16Bit {
  def and(x: Int, y: Int): Int = clearMostSignificantBytes(x & y)
  def or(x: Int, y: Int): Int = clearMostSignificantBytes(x | y)
  def leftShift(x: Int, y: Int): Int = clearMostSignificantBytes(x << y)
  def rightShift(x: Int, y: Int): Int = clearMostSignificantBytes(x >>> y)
  def not(x: Int): Int = clearMostSignificantBytes(~x)

  private def clearMostSignificantBytes(x: Int): Int = x & 65535
}
