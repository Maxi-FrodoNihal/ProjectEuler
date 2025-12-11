package problems.calendar.y25.d01

import util.IProblem

class Door25_01_Level_1 : IProblem {

   override fun getSolution() = "1023"

   override fun solve(): String {

      val circleDial = CircleDial()

      this.readLocalFile("input.txt")
         .lines()
         .map { Instruction(0,it.substring(0, 1), it.substring(1).toInt()) }
         .forEach { circleDial.doInstruction(it) }

      return circleDial.zeroCounter.toString()
   }

   private class CircleDial() {

      private var pointer = 50
      private val max = 99
      var zeroCounter = 0

      fun doInstruction(instruction: Instruction) {

         // the raw instruction amount would be also possible for the functions but then the while loops must work
         // more than they should, we can prevent this with modulo beforehand
         val normalizedMovement = instruction.amount % (max + 1)

         when (instruction.direction) {
            "L" -> doLeft(normalizedMovement)
            "R" -> doRight(normalizedMovement)
         }

         if (pointer == 0) {
            zeroCounter++
         }
      }

      private fun doLeft(amount: Int) {
         pointer -= amount
         while (pointer < 0) {
            pointer += max + 1
         }
      }

      private fun doRight(amount: Int) {
         pointer += amount
         while (pointer > max) {
            pointer -= max + 1
         }
      }
   }
}