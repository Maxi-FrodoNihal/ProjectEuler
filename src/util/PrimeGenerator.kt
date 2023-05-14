package util

import java.util.*
import kotlin.math.sqrt

fun main() {
   PrimeGenerator().maxPrimes()
//
//   var check = false
//   var border = Int.MAX_VALUE
//
//   while (check == false) {
//      check = intCheck(border)
//      --border
//
//      if (check == false) {
//
//         if (border % 20 == 0) {
//            println(border)
//         }
//
//      } else {
//         println(border)
//      }
//
//   }

}


fun intCheck(border: Int): Boolean {
   val limitSqrt = sqrt(border.toDouble()).toInt()

   val exBorder1: Long = 4 * limitSqrt.toLong() * limitSqrt.toLong() + limitSqrt.toLong() * limitSqrt.toLong()
   val exBorder2: Long = 3 * limitSqrt.toLong() * limitSqrt.toLong() + limitSqrt.toLong() * limitSqrt.toLong()
   val exBorder3: Long = 3 * limitSqrt.toLong() * limitSqrt.toLong() - limitSqrt.toLong() * limitSqrt.toLong()
   val exBorder4: Long = limitSqrt.toLong() * limitSqrt.toLong()
   val exList = listOf(exBorder1, exBorder2, exBorder3, exBorder4)

   if (exList.count { e -> e > Int.MAX_VALUE } > 0) {
      return false
   }

   return true
}

class PrimeGenerator {

   fun maxPrimes() {

      var maxParam = 429525624
      var datList = listOf<Int>()

      while (datList.isEmpty()) {
         try {
            datList = sieveOfAtkin(maxParam)
         } catch (e: Throwable) {
            maxParam--
            datList = listOf<Int>()
            println("$maxParam -> " + e::class.simpleName)
         }
      }

      println(datList.size)
      println(datList.last())
      println("DONE :)")
   }

   private fun sieveOfAtkin(border: Int): List<Int> {
      val primList: MutableList<Int> = ArrayList()
      val sieve = BooleanArray(border + 1)
      val limitSqrt = sqrt(border.toDouble()).toInt()

//      val exBorder1: Long = 4 * limitSqrt.toLong() * limitSqrt.toLong() + limitSqrt.toLong() * limitSqrt.toLong()
//      val exBorder2: Long = 3 * limitSqrt.toLong() * limitSqrt.toLong() + limitSqrt.toLong() * limitSqrt.toLong()
//      val exBorder3: Long = 3 * limitSqrt.toLong() * limitSqrt.toLong() - limitSqrt.toLong() * limitSqrt.toLong()
//      val exBorder4: Long = limitSqrt.toLong() * limitSqrt.toLong()
//      val exList = listOf(exBorder1, exBorder2, exBorder3, exBorder4)
//
//      if (exList.count { e -> e > Int.MAX_VALUE } > 0) {
//         throw Exception("Hallo")
//      }


      Arrays.fill(sieve, false)
      sieve[0] = false
      sieve[1] = false
      sieve[2] = true
      sieve[3] = true
      for (x in 1..limitSqrt) {
         for (y in 1..limitSqrt) {
            var n = 4 * x * x + y * y
            if (n <= border && (n % 12 == 1 || n % 12 == 5)) {
               sieve[n] = !sieve[n]
            }
            n = 3 * x * x + y * y
            if (n <= border && n % 12 == 7) {
               sieve[n] = !sieve[n]
            }
            n = 3 * x * x - y * y
            if (x > y && n <= border && n % 12 == 11) {
               sieve[n] = !sieve[n]
            }
         }
      }
      for (n in 5..limitSqrt) {
         if (sieve[n]) {
            val x = n * n
            var i = x
            while (i <= border) {
               sieve[i] = false
               i += x
            }
         }
      }
      for (i in 0..border) {
         if (sieve[i]) {
            primList.add(i)
         }
      }
      return primList
   }
}