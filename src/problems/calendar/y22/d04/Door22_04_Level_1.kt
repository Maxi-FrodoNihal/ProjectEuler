package problems.calendar.y22.d04

import util.IProblem

class Door22_04_Level_1 : IProblem {

   override fun getSolution(): String {
      return "509"
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
         .count { Section.containsComplete(it[0], it[1]) }
         .toString()
   }

   private class Section(val from: Int, val to: Int) {

      fun contains(otherSection: Section): Boolean {
         return this.from <= otherSection.from && this.to >= otherSection.to
      }

      companion object {
         fun containsComplete(s1: Section, s2: Section): Boolean {
            return s1.contains(s2) || s2.contains(s1)
         }
      }
   }
}