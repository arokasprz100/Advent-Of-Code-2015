package day03

object MovementExtractor {
  def unapply(str: String): Option[(Int, Int)] = {
    if(str.length > 0 && str(0) == '^') Some(0, 1)
    else if(str.length > 0 && str(0) == 'v') Some(0, -1)
    else if(str.length > 0 && str(0) == '<') Some(-1, 0)
    else if(str.length > 0 && str(0) == '>') Some(1, 0)
    else None
  }
}
