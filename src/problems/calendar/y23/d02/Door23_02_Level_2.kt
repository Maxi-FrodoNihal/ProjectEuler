package problems.calendar.y23.d02

import util.IProblem
import java.io.File

class Door23_02_Level_2 : IProblem {

   private class Element(val amount: Int, val color: String)

   override fun getSolution() = "87984"

   override fun solve() =
    File(this.javaClass.getResource("input.txt")!!.file)
      .readText()
      .lines().map {it.split(":")[1].split(";")}
      .map { line ->
         line.map { section ->
            section.split(",")
               .map(::stringToElement)
         }
      }.map (::getMaxFromEachColor)
       .sumOf { it.filterNotNull().map(Element::amount).reduce(Int::times) }
      .toString()

   private fun stringToElement(string: String) =
      Element(string.trim().split(" ")[0].toInt(), string.trim().split(" ")[1])

   private fun getMaxFromEachColor(list : List<List<Element>>) =
      list.flatten()
         .groupBy { it.color }
         .map { it.value.maxByOrNull { element -> element.amount } }
}
