package problems.calendar.y23.d01

import util.IProblem
import java.io.File

class Door23_01_Level_1 : IProblem {

   override fun getSolution() = "54632"

   override fun solve() = File(this.javaClass.getResource("input.txt")!!.file)
      .readText()
      .lines()
      .sumOf { e ->
         val letters = e.toList().map { it.toString() }
         val d1 = letters.first() { it.toIntOrNull() != null }
         val d2 = letters.last() { it.toIntOrNull() != null }
         (d1 + d2).toInt()
      }
      .toString()
}