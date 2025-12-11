package problems.calendar.y25.d01

class SimuCircleDial : AbstractCircleDial {

   constructor() : super()
   constructor(pointer: Int, zeroCounter: Int) : super(pointer, zeroCounter)

   override fun doInstruction(instruction: Instruction) {
      when (instruction.direction) {
         "L" -> goLeft(instruction)
         "R" -> goRight(instruction)
      }
   }


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