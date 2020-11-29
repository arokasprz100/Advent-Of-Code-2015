package day01

import common.FileToStringReader
import scala.annotation.tailrec

object Part2 {

  def findFirstPositionInBasement(input: IndexedSeq[Int]): Int = {

    @tailrec
    def traverseInput(currentLevel: Int, currentPosition: Int): Int = {
      if(currentLevel < 0) currentPosition
      else traverseInput(currentLevel + input(currentPosition), currentPosition + 1)
    }

    traverseInput(0, 0)
  }


  def main(args: Array[String]): Unit = {
    val input = FileToStringReader.read("src/main/scala/day01/input.txt")
    val inputAsInts = input.collect({
      case '(' => 1
      case ')' => -1
    })
    println(s"First position inside basement: ${findFirstPositionInBasement(inputAsInts)}")
  }

}
