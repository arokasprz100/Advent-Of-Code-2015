package day12

import day12.JSONParserHelpers.{removeBorders, splitOnComas}


object JSONParser {

  object NumberExtractor {
    def unapply(str: String): Option[Int] = {
      if(str.matches("^-?[0-9]+$")) Some(str.toInt)
      else None
    }
  }

  object StringExtractor {
    def unapply(str: String): Option[String] = {
      if(str.matches("^\\\"[^\"]+\\\"$")) Some(removeBorders(str))
      else None
    }
  }

  object ListExtractor {
    def unapply(str: String): Option[List[String]] = {
      if(str.startsWith("[")) Some(splitOnComas(removeBorders(str)))
      else None
    }
  }

  object ObjectExtractor {
    def unapply(str: String): Option[Map[String, String]] = {
      if(str.startsWith("{")) Some(splitOnComas(str.substring(1, str.length - 1))
        .map(x => x.split(":", 2)).map(x => (removeBorders(x(0).trim), x(1).trim)).toMap)
      else None
    }
  }

  def processJsonString(str: String): Any = str match {
    case ListExtractor(l) => l.map(processJsonString)
    case StringExtractor(s) => s
    case NumberExtractor(n) => n
    case ObjectExtractor(m) => m.map(x => x._1 -> processJsonString(x._2))
  }
  
}
