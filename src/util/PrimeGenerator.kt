package util

import java.lang.Exception
import java.util.*

fun main(){
   PrimeGenerator().maxPrimes()
}

class PrimeGenerator {

   fun maxPrimes(){

      var maxParam = Int.MAX_VALUE
      var datList = listOf<Int>()

      while (datList.isEmpty()) {
         try {
            datList = sieveOfAtkin(maxParam)
         } catch (e: Throwable) {
            maxParam--
            datList = listOf<Int>()
            println("$maxParam -> "+e::class.simpleName)
         }
      }

      for(i in 0 until 5){
         println(datList.get(i))
      }
      println("DONE :)")
   }

   private fun sieveOfAtkin(border: Int): List<Int> {
      val primList: MutableList<Int> = ArrayList()
      val sieve = BooleanArray(border + 1)
      val limitSqrt = Math.sqrt(border.toDouble()).toInt()
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