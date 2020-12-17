package day16

import common.FileToLineListReader
import day16.AuntsDescriptionsParser.parseAuntSueDescription

object Part2 extends App {

  def validateAuntSue(aunt: AuntSue, message: Map[String, Int]): Boolean = {
    val greaterThanFields = List("cats", "trees")
    val fewerThanFields = List("pomeranians", "goldfish")
    message.map(field => {
      if(!aunt.features.contains(field._1)) true
      else if(greaterThanFields.contains(field._1)) aunt.features(field._1) > field._2
      else if(fewerThanFields.contains(field._1)) aunt.features(field._1) < field._2
      else aunt.features(field._1) == field._2
    }).forall(_ == true)
  }

  val puzzleInput = FileToLineListReader.read("src/main/scala/day16/input.txt")
  val aunts = puzzleInput.map(parseAuntSueDescription)
  val validatedAunts = aunts.map(aunt => aunt.number -> validateAuntSue(aunt, MessageFromAunt.content))
  val validAunts = validatedAunts.filter(aunt => aunt._2).map(_._1)
  println(s"Number of proper aunt Sue: ${validAunts.head}")
}
