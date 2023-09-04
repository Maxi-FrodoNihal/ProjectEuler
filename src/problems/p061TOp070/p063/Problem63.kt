package problems.p061TOp070.p063

import util.IProblem
import java.math.BigDecimal

class Problem63 : IProblem{

   override fun getSolution(): String {
      return "49"
   }

   override fun solve(): String {

      var counter = 0

      for(base in 1..10){
         for(exp in 0.. 100){
            if(countDigits(BigDecimal(base).pow(exp)) == exp){
               ++counter
            }
         }
      }

      return counter.toString()
   }

   private fun countDigits(number:BigDecimal) = number.precision()-number.scale()
}