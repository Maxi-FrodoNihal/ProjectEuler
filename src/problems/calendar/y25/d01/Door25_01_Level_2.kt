package problems.calendar.y25.d01

import util.IProblem
import kotlin.random.Random

class Door25_01_Level_2 : IProblem {

   override fun getSolution() = "5899"

   override fun solve(): String {
//      val mathCircleDial = MathCircleDial(50,0)
//      val simuCircleDial = SimuCircleDial(50,0)
//
//      val instruction = Instruction(54,"R",50)
//
//      println("instruction: $instruction")
//      simuCircleDial.doInstruction(instruction)
//      logCircleDial(simuCircleDial)
//      mathCircleDial.doInstruction(instruction)
//      logCircleDial(mathCircleDial)

//
//      mainTest1(mathCircleDial, simuCircleDial)
      while (randomMainTest(MathCircleDial(), SimuCircleDial(), 10000, false)){

      }



      return ""
   }

   private fun mainTest1(mathCircleDial: MathCircleDial, simuCircleDial: SimuCircleDial){

      var counter = 0

      val instructionList = this.readLocalFile("input.txt")
         .lines()
         .map { Instruction(++counter, it.substring(0, 1), it.substring(1).toInt()) }

      for (instruction in instructionList) {
         println("instruction: $instruction")
         simuCircleDial.doInstruction(instruction)
         logCircleDial(simuCircleDial)
         mathCircleDial.doInstruction(instruction)
         logCircleDial(mathCircleDial)

         if(!mathCircleDial.equals(simuCircleDial)) {
            break
         }
      }
   }


   private fun randomMainTest(mathCircleDial: MathCircleDial, simuCircleDial: SimuCircleDial, simuSteps: Int, logStuff: Boolean): Boolean{

      val instructionList =List(simuSteps) { nextRandomInstruction(it+1) }

      for (instruction in instructionList) {

            simuCircleDial.doInstruction(instruction)
            mathCircleDial.doInstruction(instruction)

         if(logStuff) {
            println("instruction: $instruction")
            logCircleDial(simuCircleDial)
            logCircleDial(mathCircleDial)
         }

         if(!mathCircleDial.equals(simuCircleDial)) {
            return false
         }
      }
      return true
   }

   private fun nextRandomInstruction(counter: Int): Instruction{

      val isR = Random.nextBoolean()
      val direction = if (isR) "R" else "L"

      return Instruction(counter+1,  direction,Random.nextInt(1, 1000))
   }

   private fun logCircleDial(abstractCircleDial: AbstractCircleDial){
      val className = abstractCircleDial.javaClass.simpleName
      println("$className pointer -> ${abstractCircleDial.pointer} zerocounter -> ${abstractCircleDial.zeroCounter}")
   }
}