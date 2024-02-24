package problems.calendar.y23.d04

import util.IProblem
import java.io.File

class Door23_04_Level_2 : IProblem {

   override fun getSolution(): String {
      return "14427616"
   }

   private fun lineToInts(line:String) =
      line.split(" ")
          .filter(String::isNotEmpty)
          .map(String::toInt)

   override fun solve(): String {

      val cardLines = File(this.javaClass.getResource("input.txt")!!.file)
         .readText()
         .lines()

      val copyList = MutableList(cardLines.size) { 1 }

      cardLines // Example Line: Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
         .map {
            val leftList = it.substring(it.indexOf(":")+1)
               .split("|")[0]
               .let(::lineToInts)

            val rightList = it.split("|")[1]
               .let(::lineToInts)

            Pair(leftList, rightList)
         }.forEachIndexed { index, pair ->

            val leftList = pair.first
            val rightList = pair.second

            val lonelyNumbers = rightList.minus(leftList)
            val sameNumberAmount = rightList.size - lonelyNumbers.size

            for (i in index + 1..index + sameNumberAmount) {
               val nextCard = copyList.get(i)
               copyList.set(i, nextCard+copyList.get(index))
            }
         }

      return copyList.sum().toString()
   }
}