package day09

import common.FileToLineListReader

object Solution extends App {

  def parseRoute(str: String): ((String, String), Int) = {
    val parts = str.split(" ").map(_.trim)
    (parts(0), parts(2)) -> parts(4).toInt
  }

  def routeLength(route: List[String], paths: Map[(String, String), Int]): Int = {
    route.tail.foldLeft((0, route.head))((x, y) => (x._1 + paths((x._2, y)), y))._1
  }

  val input = FileToLineListReader.read("src/main/scala/day09/input.txt").map(line => parseRoute(line)).toMap
  val paths = input.map(x => (x._1._2, x._1._1) -> x._2) ++ input
  val locations = paths.keys.map(_._1).toList.distinct
  val routesLengths = locations.permutations.map(routeLength(_, paths)).toList
  println(s"Part 1: shortest route: ${routesLengths.min}")
  println(s"Part 2: longest route: ${routesLengths.max}")
}
