package problems.calendar.y22.d03

import util.IProblem

class Door22_03_Level_1 : IProblem {

   override fun getSolution(): String {
      return "8039"
   }

   override fun solve(): String {

      val alphabetMap = generateAlphabetMap()

      return this.readLocalFile("input.txt").lines()
         .map { getWantedLetter(it) }
         .sumOf { letter -> alphabetMap.getOrDefault(letter, 0) }.toString()
   }

   private fun getWantedLetter(line: String): Char {

      val halfLineLength = line.length / 2

      val oneHalf = line.substring(0, halfLineLength)
      val secondHalf = line.substring(halfLineLength)

      return oneHalf.first { secondHalf.contains(it) }
   }

   private fun generateAlphabetMap(): Map<Char, Int> {

      val lowerCaseList = ('a'..'z').mapIndexed { index, c -> c to index + 1 }
      val upperCaseList = ('A'..'Z').mapIndexed { index, c -> c to index + 27 }

      return lowerCaseList.toMap() + upperCaseList.toMap()
   }
}