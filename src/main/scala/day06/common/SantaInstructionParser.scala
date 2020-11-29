package day06.common

import Types.Coords

object SantaInstructionParser {
  final def getCoordinates(str: String): (Coords, Coords) = {
    val Array(start, end) = str.split("through", 2)
    val Array(startX, startY) = start.split(",", 2).map(_.trim.toInt)
    val Array(endX, endY) = end.split(",", 2).map(_.trim.toInt)
    ((startX, startY), (endX, endY))
  }
}
