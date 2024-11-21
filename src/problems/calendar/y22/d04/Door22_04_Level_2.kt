package problems.calendar.y22.d04

import util.IProblem

class Door22_04_Level_2 : IProblem {

   override fun getSolution(): String {
      return "870"
   }

   override fun solve(): String {
      return this.readLocalFile("input.txt")
         .lines()
         .map { it.split(",") }
         .flatten()
         .map { it.split("-") }
         .map { it.map(String::toInt) }
         .map { Section(it[0], it[1]) }
         .chunked(2)
         .count { Section.getOverlappingElements(it[0], it[1]).isNotEmpty() }
         .toString()
   }

   private class Section(val from: Int, val to: Int) {

      private fun getElementSet(): Set<Int> {
         return (from..to).toSet()
      }

      companion object {
         fun getOverlappingElements(s1: Section, s2: Section): Set<Int> {
            return s1.getElementSet().intersect(s2.getElementSet())
         }
      }
   }
}