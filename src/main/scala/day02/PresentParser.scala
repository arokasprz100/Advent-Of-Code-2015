package day02

object PresentParser {

  def parsePresentDescriptionString(description: String): (Int, Int, Int) = {
    val dimensionStrings = description.split("x")
    (dimensionStrings(0).toInt, dimensionStrings(1).toInt, dimensionStrings(2).toInt)
  }

}
