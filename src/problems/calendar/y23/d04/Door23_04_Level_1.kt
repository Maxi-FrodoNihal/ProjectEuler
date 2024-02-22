package problems.calendar.y23.d04

import org.apache.commons.math3.util.ArithmeticUtils
import util.IProblem
import java.io.File

class Door23_04_Level_1 : IProblem {

   private fun lineToInts(line:String) =
      line.split(" ")
          .filter(String::isNotEmpty)
          .map(String::toInt)

   override fun solve() =
      File(this.javaClass.getResource("input.txt")!!.file)
         .readText()
         .lines() // Example Line: Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
         .map {
            val leftList = it.substring(10)
               .split("|")[0]
               .let(::lineToInts)

            val rightList = it.split("|")[1]
               .let(::lineToInts)

            Pair(leftList, rightList)
         }.sumOf {

            val leftList = it.first
            val rightList = it.second

            val lonelyNumbers = rightList.minus(leftList)
            val sameNumberAmount = rightList.size - lonelyNumbers.size

            var points = 0

            if (sameNumberAmount > 0) {
               points = ArithmeticUtils.pow(2, sameNumberAmount - 1)
            }

            points
         }.toString()
}