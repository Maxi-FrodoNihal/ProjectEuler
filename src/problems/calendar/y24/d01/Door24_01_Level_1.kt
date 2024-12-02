package problems.calendar.y24.d01

import util.IProblem
import kotlin.math.abs

class Door24_01_Level_1 : IProblem {

   override fun getSolution(): String {
      return "3574690"
   }

   override fun solve(): String {
      return this.readLocalFile("input.txt")
         .lines()
         .map { it.split("   ") }
         .map { it[0].toInt() to it[1].toInt() }
         .unzip()
         .let { (leftList, rightList) -> leftList.sorted() to rightList.sorted() }
         .let { it.first.mapIndexed { index, element -> abs(element - it.second[index]) }.sum().toString() }
   }
}