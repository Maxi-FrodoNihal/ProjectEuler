package problems.calendar.y22.d01

import util.IProblem
import java.io.File

class Door22_01_Level_1 : IProblem {

   override fun getSolution() = "71502"

   override fun solve() =
      File(this.javaClass.getResource("input.txt")!!.file)
         .readText()
         .split(regex = Regex("""\r?\n\s*\r?\n"""))
         .maxOfOrNull { it.lines().sumOf(String::toInt) }
         .toString()
}