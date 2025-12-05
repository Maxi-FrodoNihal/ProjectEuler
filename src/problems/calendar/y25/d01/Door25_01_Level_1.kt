package problems.calendar.y25.d01

import util.IProblem

class Door25_01_Level_1 : IProblem {

   override fun solve(): String {

      val circleDial = CircleDial()

      this.readLocalFile("input.txt")
         .lines()
         .map { Instruction(it.substring(0, 1), it.substring(1).toInt()) }
         .forEach { circleDial.doInstruction(it) }

      return circleDial.zeroCounter.toString()
   }

   data class Instruction(val direction: String, val amount: Int)

   private class CircleDial() {

      private var pointer = 50
      private val max = 99
      var zeroCounter = 0

      fun doInstruction(instruction: Instruction) {
         when (instruction.direction) {
            "L" -> doLeft(instruction.amount)
            "R" -> doRight(instruction.amount)
         }

         if(pointer == 0){
            zeroCounter++
         }
      }

      private fun doLeft(amount: Int){
         pointer -= amount
         while (pointer < 0){
            ++pointer
            pointer+=max
         }
      }

      private fun doRight(amount: Int){
         pointer += amount
         while (pointer > max){
            --pointer
            pointer -= max
         }
      }
   }
}