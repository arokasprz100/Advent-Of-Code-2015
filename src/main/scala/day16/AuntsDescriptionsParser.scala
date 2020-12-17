package day16

object AuntsDescriptionsParser {

  def parseAuntSueDescription(description: String): AuntSue = {
    val auntSuePattern = "Sue ([0-9]+): (.*)".r
    val auntSuePattern(id, featuresDescription) = description
    val features = featuresDescription.split(",").map(_.trim).map(x => {
      val Array(key, value) = x.split(":").map(_.trim)
      (key, value.toInt)
    }).toMap
    AuntSue(id.toInt, features)
  }

}
