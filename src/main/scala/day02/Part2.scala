package day02

import PresentParser._
import common.FileToLineListReader

object Part2 extends App {

  def presentVolume(dimensions: (Int, Int, Int)): Int = {
    dimensions._1 * dimensions._2 * dimensions._3
  }

  def presentRibbonLength(dimensions: (Int, Int, Int)): Int = {
    val sums = List(dimensions._1 + dimensions._2, dimensions._1 + dimensions._3, dimensions._2 + dimensions._3)
    2 * sums.min + presentVolume(dimensions)
  }

  val input = FileToLineListReader.read("src/main/scala/day02/input.txt")
  println(s"Total ribbon length: ${input.map(parsePresentDescriptionString).map(presentRibbonLength).sum}")

}
