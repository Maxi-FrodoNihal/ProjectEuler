package problems.calendar.y23.d01

import util.IProblem
import java.io.File

class Door23_01_Level_2 : IProblem {

   private class Replacer(val index: Int, val replacement: String)

   private val numberMap = mapOf(
      "one" to "1",
      "two" to "2",
      "three" to "3",
      "four" to "4",
      "five" to "5",
      "six" to "6",
      "seven" to "7",
      "eight" to "8",
      "nine" to "9"
   )

   override fun getSolution() = "54019"

   override fun solve() =
      this.readLocalFile("input.txt")
         .lines()
         .map(this::replaceNumberWord)
         .sumOf { e ->
            val letters = e.toList().map { it.toString() }
            val d1 = letters.first() { it.toIntOrNull() != null }
            val d2 = letters.last() { it.toIntOrNull() != null }
            (d1 + d2).toInt()
         }
         .toString()

   private fun replaceNumberWord(word: String) =
      listOf(extractReplacerDigitsFromWord(word), extractReplacerLetterDigitsFromWord(word))
         .flatten()
         .sortedBy(Replacer::index)
         .map(Replacer::replacement)
         .joinToString("")

   private fun extractReplacerDigitsFromWord(word: String) =
      word.filter { char -> char.isDigit() }
         .map { digitChar ->
            indexesOfSub(word, digitChar.toString())
               .map { index ->
                  Replacer(
                     index,
                     digitChar.toString()
                  )
               }
         }.flatten()

   private fun extractReplacerLetterDigitsFromWord(word: String) =
      numberMap.keys.map { numberWord ->
         indexesOfSub(word, numberWord).map { index ->
            Replacer(
               index,
               numberMap.getOrDefault(numberWord, "")
            )
         }
      }.flatten()

   private fun indexesOfSub(word: String, subword: String): List<Int> =
      generateSequence(word.indexOf(subword)) {
         word.indexOf(subword, it + 1)
      }.takeWhile { it >= 0 }
         .toList()
}