package problems.calendar.y25.d01

import util.IProblem

class Door25_01_Level_2 : IProblem {

   override fun getSolution() = "5899"

   override fun solve(): String {

      val circleDial = CircleDial()

      this.readLocalFile("input.txt")
         .lines()
         .map { Instruction(0,it.substring(0, 1), it.substring(1).toInt()) }
         .forEach { circleDial.doInstruction(it) }

      return circleDial.zeroCounter.toString()
   }

   private class CircleDial{

      private var pointer = 50
      private val max = 99
      var zeroCounter = 0

      fun doInstruction(instruction: Instruction) {
         when (instruction.direction) {
            "L" -> doLeft(instruction)
            "R" -> doRight(instruction)
         }
      }

      private fun doLeft(instruction: Instruction) {
         // special anti symmetric advent of code rule:
         // first letf side wrap up will not be counted if the pointer was on start at 0
         var pointerWasAtZeroOnce = pointer == 0
         pointer -= instruction.amount
         while (pointer < 0) {
            if(pointerWasAtZeroOnce){
               pointerWasAtZeroOnce=false
            }else{
               ++zeroCounter
            }
            pointer += max + 1
         }
         if (pointer == 0) {
            ++zeroCounter
         }
      }

      private fun doRight(instruction: Instruction) {
         pointer += instruction.amount
         while (pointer > max) {
            ++zeroCounter
            pointer -= max + 1
         }
      }

      // raw simulation implementation

      private fun goRight(instruction:Instruction) {
         for(i in 1..instruction.amount){
            ++pointer
            if(pointer > max){
               pointer-=max+1
            }
            if(pointer == 0){
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
               ++zeroCounter
            }
         }
      }
   }
}