package problems.calendar.y25.d01

import util.IProblem

class Door25_01_Level_2 : IProblem {

   // off by one
   override fun getSolution() = "5899"

   override fun solve(): String {
      val circleDial = CircleDial()
      var counter = 0

      this.readLocalFile("input.txt")
         .lines()
         .map { Instruction(++counter,it.substring(0, 1), it.substring(1).toInt()) }
         .forEach { circleDial.doInstruction(it) }

      return circleDial.zeroCounter.toString()
   }

   data class Instruction(val number: Int, val direction: String, val amount: Int)

   private class CircleDial() {

      private var pointer = 50
      private val max = 99
      var zeroCounter = 0

      fun doInstruction(instruction: Instruction) {

         when (instruction.direction) {
            "L" -> doLeft(instruction)
            "R" -> doRight(instruction)
         }
      }

      private fun goRight(instruction: Instruction) {
         for(i in 1..instruction.amount){
            ++pointer
            if(pointer > max){
               pointer-=max+1
            }
            if(pointer == 0){
               println(instruction.number)
               ++zeroCounter
            }
         }
      }

      private fun goLeft(instruction: Instruction) {
         for(i in 1..instruction.amount){
            --pointer
            if(pointer < 0){
               pointer+=max+1
            }
            if(pointer == 0){
               println(instruction.number)
               ++zeroCounter
            }
         }
      }


      private fun doLeft(instruction: Instruction) {
         pointer -= instruction.amount
         while (pointer < 0) {
            println(instruction.number)
            ++zeroCounter
            pointer += max + 1
         }
      }

      private fun doRight(instruction: Instruction) {
         pointer += instruction.amount
         while (pointer > max) {
            println(instruction.number)
            ++zeroCounter
            pointer -= max + 1
         }
      }
   }
}