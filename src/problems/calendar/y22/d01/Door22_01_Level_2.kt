package problems.calendar.y22.d01

import util.IProblem

class Door22_01_Level_2 : IProblem {

   override fun getSolution() = "208191"

   override fun solve() =
      this.readLocalFile("input.txt")
         .split("\n\n")
         .map { it.lines().sumOf(String::toInt) }
         .sortedDescending()
         .take(3)
         .sum()
         .toString()
}