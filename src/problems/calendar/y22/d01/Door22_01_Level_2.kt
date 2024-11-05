package problems.calendar.y22.d01

import util.IProblem
import java.io.File

class Door22_01_Level_2 : IProblem {

   override fun getSolution() = "208191"

   override fun solve() =
      File(this.javaClass.getResource("input.txt")!!.file)
         .readText()
         .split(regex = Regex("""\r?\n\s*\r?\n"""))
         .map { it.lines().sumOf(String::toInt) }
         .sortedDescending()
         .take(3)
         .sum()
         .toString()
}