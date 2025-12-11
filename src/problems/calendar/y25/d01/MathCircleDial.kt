package problems.calendar.y25.d01

class MathCircleDial : AbstractCircleDial {

   constructor() : super()
   constructor(pointer: Int, zeroCounter: Int) : super(pointer, zeroCounter)

   override fun doInstruction(instruction: Instruction) {

      when (instruction.direction) {
         "L" -> doLeft(instruction)
         "R" -> doRight(instruction)
      }
   }

   private fun doLeft(instruction: Instruction) {
      var pointerWasAtZero = pointer == 0
      pointer -= instruction.amount
      while (pointer < 0) {
         if(!pointerWasAtZero){
            ++zeroCounter
         }else{
            pointerWasAtZero=false
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
}