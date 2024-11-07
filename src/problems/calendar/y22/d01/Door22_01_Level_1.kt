package problems.calendar.y22.d01

import util.IProblem

class Door22_01_Level_1 : IProblem {

   override fun getSolution() = "71502"

   override fun solve() =
      this.readLocalFile("input.txt")
         .split("\n\n")
         .maxOf { it.lines().sumOf(String::toInt) }
         .toString()
}