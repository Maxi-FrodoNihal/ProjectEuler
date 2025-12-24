package problems.calendar.y25.d02

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.apache.commons.lang3.StringUtils
import util.IProblem

class Door25_02_Level_1 : IProblem {

   override fun getSolution() = "29940924880"

   override fun solve(): String {
      return runBlocking {
         readLocalFile("input.txt")
            .lines()
            .flatMap { it.split(",") }
            .filter { StringUtils.isNotBlank(it) }
            .map {
               val rawRange = it.split("-")
               rawRange[0].toLong() to rawRange[1].toLong()
            }.map {

               async(Dispatchers.Default) {
                  checkForInvalidIds(it)
               }
            }
            .awaitAll()
            .flatten()
            .sum()
      }.toString()
   }

   private fun checkForInvalidIds(range: Pair<Long, Long>): Set<Long> {

      val from = range.first
      val to = range.second
      val badSet = mutableSetOf<Long>()

      for (i in from..to) {
         if (isDivByTwo(i.toString().length) && (checkForSameDigits(i) || checkForPatterns(i))) {
            badSet.add(i)
         }
      }

      return badSet
   }

   private fun checkForSameDigits(id: Long): Boolean {
      val idAsString = id.toString()
      val firstLetter = idAsString.first().toString()
      return StringUtils.containsOnly(idAsString, firstLetter)
   }

   private fun checkForPatterns(id: Long): Boolean {
      val idAsString = id.toString()
      val splitBorder = idAsString.length / 2

      val substring1 = idAsString.substring(0, splitBorder)
      val substring2 = idAsString.substring(splitBorder, idAsString.length)

      return substring1 == substring2
   }

   private fun isDivByTwo(id: Int) = id % 2 == 0
}