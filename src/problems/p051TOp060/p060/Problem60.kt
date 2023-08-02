package problems.p051TOp060.p060

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import util.prime.PrimProblem
import java.math.BigInteger
import java.util.Optional
import java.util.stream.Collector

class Problem60: PrimProblem() {
//   3;7;823;121441;912763

   val border = 100000
   val elementBorder = 5

   override fun solve():String {
      var foundPrimes = mutableSetOf<Int>()

      work(foundPrimes, 1).ifPresent{e->foundPrimes=e}

      println("solution: "+foundPrimes.joinToString(";"))
      return foundPrimes.sum().toString()
   }


   private fun work(foundPrimes:MutableSet<Int>, runningIndex:Int):Optional<MutableSet<Int>>{

      println(foundPrimes.joinToString(";"))

      if(foundPrimes.size == elementBorder && concPrimesFromList(foundPrimes)){
         return Optional.of(foundPrimes)
      }

      for(i in runningIndex until border){

         val nextPrime = this.getOrCalculate(i)
         foundPrimes.add(nextPrime)

         if(concPrimesFromList(foundPrimes)){
            val evtlFoundPrimes = work(foundPrimes, i + 1)
            if(evtlFoundPrimes.isPresent){
               return evtlFoundPrimes
            }
         }

         foundPrimes.remove(nextPrime)
      }

      return Optional.empty()
   }

   private fun concPrimesToPrimes(prime1:Int,prime2:Int) =
                  checkIfBigIsPrime(prime1.toString()+prime2.toString())
               && checkIfBigIsPrime(prime2.toString()+prime1.toString())


   private fun checkIfBigIsPrime(bigNumber:String):Boolean{
      if(bigNumber.length <= 9 && bigNumber.toInt() < this.primNumbers.last()){
         return this.isPrim(bigNumber.toInt())
      }else{
         return BigInteger(bigNumber).isProbablePrime(Int.MAX_VALUE)
      }
   }

   private fun concPrimesFromList(primes: Set<Int>): Boolean {
      if (primes.size <= 1) {
         return true
      }

      primes.forEach { prime1 ->
         primes.forEach { prime2 ->
            if (prime1 != prime2 && !concPrimesToPrimes(prime1, prime2)) {
               return false
            }
         }
      }

      return true
   }
}