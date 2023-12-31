package problems.calendar.y23.d03

import util.IProblem
import java.io.File

class Door23_03_Level_1 : IProblem {

   override fun solve(): String {

      val rawCoordinates = File(this.javaClass.getResource("input.txt")!!.file)
         .readText()
         .lines().map { it.toList().map(Char::toString) }

      println(rawCoordinates.get(1).get(4))

      return ""
   }
}