package day12

object JSONOperations {

  def removeObjectsWithRed(json: Any): Any = json match {
    case x: Map[String, Any] if x.values.exists(_ == "red") => Map()
    case x: Map[String, Any] => x.map(x => (x._1, removeObjectsWithRed(x._2)))
    case x: List[Any] => x.map(removeObjectsWithRed)
    case x => x
  }

  def jsonToString(json: Any): String = json match {
    case x: Map[String, Any] => x.map(x => "\"" + x._1 + "\"" + s": ${jsonToString(x._2)}").mkString("{", ", ", "}")
    case x: List[Any] => x.map(jsonToString).mkString("[", ", ", "]")
    case x: String => "\"" + x + "\""
    case x => x.toString
  }

}
