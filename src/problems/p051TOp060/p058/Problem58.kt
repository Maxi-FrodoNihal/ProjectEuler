package problems.p051TOp060.p058

import util.PrimProblem
import util.primelist.PrimeList
import kotlin.math.sqrt

class Problem58 : PrimProblem() {

   override fun solve(): String {

//      val primeList = PrimeList()

//      isPrim(688590081)

      var i = 1
      var odd = 0
      var primSum = 0
      var total = 0

      var primeFactor = 0.0

      do {

         odd = getOdd(++i)

//         val pair = diagonalPrims(odd,primeList)
         val pair = diagonalPrims(odd)
         primSum += pair.first
         total += pair.second

         primeFactor = primSum.toDouble() / total

      } while (primeFactor > 0.10)


      return odd.toString()
   }

   private fun diagonalPrims(size: Int, primeList: PrimeList): Pair<Int, Int> {
      val list = mutableListOf<Int>()

      list.add(size * size)

      if (size > 1) {
         for (i in 0 until 3) {
            list.add(list.last() - (size - 1))
         }
      }

      return Pair(list.count(primeList::isPrime), list.size)
   }

   private fun diagonalPrims(size: Int): Pair<Int, Int> {
      val list = mutableListOf<Int>()

      list.add(size * size)

      if (size > 1) {
         for (i in 0 until 3) {
            list.add(list.last() - (size - 1))
         }
      }

      return Pair(list.count(this::is_prime_c), list.size)
   }

   private fun getOdd(step: Int) = step * 2 - 1


   fun is_prime_c(n:Int):Boolean
   {
      if(n < 2) return false;
      if(n == 2) return true;
      if(n % 2 == 0) return false;

         var m = 3
         while (m < sqrt(n.toDouble()) + 1) {
            if (n % m == 0) return false
            m += 2
         }

      return true;
   }
}