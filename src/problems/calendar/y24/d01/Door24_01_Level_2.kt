package problems.calendar.y24.d01

import util.IProblem

class Door24_01_Level_2 : IProblem {

   override fun getSolution(): String {
      return "22565391"
   }

   override fun solve(): String {
      return this.readLocalFile("input.txt")
         .lines()
         .map { it.split("   ") }
         .map { it[0].toInt() to it[1].toInt() }
         .unzip()
         .let { pairList ->
            pairList.first.sumOf { leftElement -> leftElement * pairList.second.count { leftElement == it } }.toString()
         }
   }
}