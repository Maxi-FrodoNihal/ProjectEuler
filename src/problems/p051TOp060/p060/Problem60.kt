package problems.p051TOp060.p060

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import util.prime.PrimProblem
import java.math.BigInteger
import java.util.Optional

class Problem60: PrimProblem() {
//   3;7;823;121441;912763

   val border = 100000
   val elementBorder = 5

   override fun solve(): String {
      this.getOrCalculate(border)
      var foundPrimes = mutableSetOf<Int>()

      work(foundPrimes, 1).ifPresent{e->foundPrimes=e}


      return foundPrimes.joinToString(";")
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
                 BigInteger(prime1.toString()+prime2.toString()).isProbablePrime(Int.MAX_VALUE)
              && BigInteger(prime2.toString()+prime1.toString()).isProbablePrime(Int.MAX_VALUE)

   private fun concPrimesFromList(primes: Set<Int>):Boolean{

      var check = true

      if(primes.isEmpty() || primes.size == 1){
         return check
      }

      primes.forEach { prime1 ->
         primes.forEach { prime2 ->
           if(prime1 != prime2){
            check = check && concPrimesToPrimes(prime1,prime2)
           }
         }
      }

      return check;
   }
}