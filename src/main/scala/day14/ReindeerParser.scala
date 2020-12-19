package day14

object ReindeerParser {

  private val reindeerPattern = "^([a-zA-Z]+) can fly ([0-9]+) km/s for ([0-9]+) [a-zA-Z, ]+ ([0-9]+) seconds\\.".r

  def parseReindeer(str: String): Reindeer = {
    val groups = reindeerPattern.findAllIn(str).subgroups
    Reindeer(groups.head, groups(1).toInt, groups(2).toInt, groups(3).toInt)
  }

}