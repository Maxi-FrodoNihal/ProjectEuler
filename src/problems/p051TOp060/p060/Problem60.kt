package problems.p051TOp060.p060

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import util.prime.PrimProblem
import java.math.BigInteger
import java.util.Optional

class Problem60: PrimProblem() {

   val border = 1000
   val elementBorder = 4

   override fun solve(): String {
      this.getOrCalculate(border)
      var foundPrimes = mutableListOf<Int>()

      for (i in 1..border ){

         if(foundPrimes.isEmpty()){
            foundPrimes.add(this.getOrCalculate(i))
            println(foundPrimes.last())
         }

         innerMethod(i,foundPrimes).ifPresent{e->foundPrimes = e}

         if(concPrimesFromList(foundPrimes) && foundPrimes.size == elementBorder){
            break
         }else{
            foundPrimes.clear()
         }
      }

      return foundPrimes.joinToString(";")
   }


   private fun innerMethod(externIndex:Int, foundPrimes:MutableList<Int>):Optional<MutableList<Int>>{

      for (j in 0..border ){
         if(externIndex != j){
            foundPrimes.add(getOrCalculate(j))

            if(!concPrimesFromList(foundPrimes)){
               foundPrimes.removeLast()
            }

            if(foundPrimes.size == elementBorder) {
               return Optional.of(foundPrimes)
            }
         }
      }

      return Optional.empty();
   }

   private fun concPrimesToPrimes(prime1:Int,prime2:Int) =
                 BigInteger(prime1.toString()+prime2.toString()).isProbablePrime(Int.MAX_VALUE)
              && BigInteger(prime2.toString()+prime1.toString()).isProbablePrime(Int.MAX_VALUE)

   private fun concPrimesFromList(primes: List<Int>):Boolean{

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