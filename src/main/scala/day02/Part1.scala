package day02

import common.FileToLineListReader
import PresentParser._

object Part1 extends App {

  def calculatePresentArea(dimensions: (Int, Int, Int)): Int = {
    val products = List(dimensions._1 * dimensions._2, dimensions._1 * dimensions._3, dimensions._2 * dimensions._3)
    products.min + 2 * products.head + 2 * products(1) + 2 * products(2)
  }

  val input = FileToLineListReader.read("src/main/scala/day02/input.txt")
  println(s"Total wrapping paper: ${input.map(parsePresentDescriptionString).map(calculatePresentArea).sum}")
}
