package problems.calendar.y22.d03

import util.IProblem

class Door22_03_Level_2 : IProblem {

   override fun getSolution(): String {
      return "2510"
   }

   override fun solve(): String {

      val alphabetMap = generateAlphabetMap()

      return this.readLocalFile("input.txt").lines()
         .chunked(3)
         .map(::getWantedLetter)
         .sumOf { letter ->
            alphabetMap.getOrDefault(letter, 0)
         }.toString()
   }

   private fun getWantedLetter(elementList: List<String>): Char {

      val firstElement = elementList[0]
      val subList = elementList.subList(1, elementList.size)

      return firstElement.first { letter -> subList.all { it.contains(letter) } }
   }

   private fun generateAlphabetMap(): Map<Char, Int> {

      val lowerCaseList = ('a'..'z').mapIndexed { index, c -> c to index + 1 }
      val upperCaseList = ('A'..'Z').mapIndexed { index, c -> c to index + 27 }

      return lowerCaseList.toMap() + upperCaseList.toMap()
   }
}