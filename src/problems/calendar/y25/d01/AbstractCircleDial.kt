package problems.calendar.y25.d01

abstract class AbstractCircleDial {

   var pointer = 50
   protected val max = 99
   var zeroCounter = 0

   constructor()

   constructor(pointer: Int, zeroCounter: Int) {
      this.pointer = pointer
      this.zeroCounter = zeroCounter
   }

   abstract fun doInstruction(instruction: Instruction)

   override fun equals(other: Any?): Boolean {
      if (this === other) return true

      other as AbstractCircleDial

      if (pointer != other.pointer) return false
      if (zeroCounter != other.zeroCounter) return false

      return true
   }

   override fun hashCode(): Int {
      var result = pointer
      result = 31 * result + zeroCounter
      return result
   }
}