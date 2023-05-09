package problems.p051TOp060.p058

import util.PrimProblem

class Problem58 : PrimProblem() {
   override fun solve(): String {

      isPrim(10)

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
         val lastPrim = this.primNumbers.last()
         if (i % 40 == 0)
            println("$odd -> $primeFactor prim $lastPrim")

      } while (primeFactor > 0.10)


      return odd.toString()
   }

   fun diagonalPrims(size: Int): Pair<Int, Int> {
      val list = mutableListOf<Int>()

      list.add(size * size)

      if (size > 1) {
         for (i in 0 until 3) {
            list.add(list.last() - (size - 1))
         }
      }

      return Pair(list.count(::isPrim), list.size)
   }

   fun getOdd(step: Int) = step * 2 - 1
}