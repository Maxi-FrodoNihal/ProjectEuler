package problems.p051TOp060.p058

import util.PrimProblem

class Problem58 : PrimProblem() {

//   private var primeList = PrimeList()

   override fun solve(): String {

      isPrim(688590081)

      var i = 1
      var odd = 0
      var primSum = 0
      var total = 0

      var primeFactor = 0.0

      do {

         odd = getOdd(++i)

         val pair = diagonalPrims(odd)
         primSum += pair.first
         total += pair.second

         primeFactor = primSum.toDouble() / total

      } while (primeFactor > 0.10)


      return odd.toString()
   }

   private fun diagonalPrims(size: Int): Pair<Int, Int> {
      val list = mutableListOf<Int>()

      list.add(size * size)

      if (size > 1) {
         for (i in 0 until 3) {
            list.add(list.last() - (size - 1))
         }
      }

      return Pair(list.count(::isPrim), list.size)
   }

   private fun getOdd(step: Int) = step * 2 - 1
}