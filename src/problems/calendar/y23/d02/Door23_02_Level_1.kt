package problems.calendar.y23.d02

import util.IProblem
import java.io.File

class Door23_02_Level_1 : IProblem {

   private class Element(val amount: Int, val color: String)
   private val checkList = listOf(Element(12, "red"), Element(13, "green"), Element(14, "blue"))

   override fun getSolution() = "2486"

   override fun solve() =
      this.readLocalFile("input.txt")
      .lines().map {it.split(":")[1].split(";")}
      .map { line ->
         line.map {
            section ->
               section.split(",")
                      .map(::stringToElement)
         }
      }.withIndex()
      .filter { e -> e.value.all(::isPossible) }
      .sumOf { it.index+1 }
      .toString()

   private fun stringToElement(string: String) =
      Element(string.trim().split(" ")[0].toInt(), string.trim().split(" ")[1])
   private fun isPossible(list: List<Element>) =
      list.all { element -> checkList.first { it.color == element.color }.amount >= element.amount }
}