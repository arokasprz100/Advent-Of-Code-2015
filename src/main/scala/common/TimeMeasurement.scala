package common

object TimeMeasurement {

  def timeMeasurement[T](code: => T): T = {
    val start = System.nanoTime()
    val result = code
    val stop = System.nanoTime()
    println(s"Elapsed time: ${(stop - start) / 1000000000.0} s")
    result
  }

}
