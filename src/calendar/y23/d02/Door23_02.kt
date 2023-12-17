package calendar.y23.d02

import util.IProblem
import java.io.File

class Door23_02 : IProblem {

   private val testLines = listOf(
      // twone
      "two1nine",
      "eightwothree",
      "abcone2threexyz",
      "xtwone3four",
      "4nineeightseven2",
      "zoneight234",
      "7pqrstsixteen"
   )

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

   override fun getSolution(): String {
      return "53992"
   }

   private fun replaceWordRightToLeft(word: String): String {

      var replaceWord = word

      while (numberMap.keys.count { replaceWord.contains(it) } > 0) {
         numberMap.keys
            .filter { replaceWord.contains(it) }
            .map { Pair(it, replaceWord.indexOf(it)) }
            .sortedBy(Pair<String, Int>::second)
            .forEach { replaceWord = replaceWord.replaceFirst(it.first, numberMap.getOrDefault(it.first, "")) }
      }

      return replaceWord
   }

   override fun solve() =
      File(this.javaClass.getResource("input.txt")!!.file)
         .readText()
         .lines()
//      testLines
         .map(this::replaceWordRightToLeft)
         .sumOf { e ->
            println(e)
            val letters = e.toList().map { it.toString() }
            val d1 = letters.first() { it.toIntOrNull() != null }
            val d2 = letters.last() { it.toIntOrNull() != null }
            (d1 + d2).toInt()
         }
         .toString()

   fun findAllIndicesOfSubstring(input: String, sub: String): List<Int> {
      val indices = mutableListOf<Int>()
      var index = input.indexOf(sub, 0)

      while (index >= 0) {
         indices.add(index)
         index = input.indexOf(sub, index + 1)
      }

      return indices
   }
}
