package problems.p051TOp060.p060

import util.prime.PrimProblem
import java.math.BigInteger

class Problem60: PrimProblem() {

   val border = 1000
   val elementBorder = 4

   override fun solve() = crawlPrimes(mutableListOf(), ::getOrCalculate , 0, 0).joinToString(";")

   fun crawlPrimes(foundPrimes:MutableList<Int>, primes: (input: Int) -> Int , index:Int, clearTimes:Int):List<Int>{

      var internalClearTimes = clearTimes
      var internalIndex = index

      if(internalIndex < border){
         if(foundPrimes.isEmpty()){
            foundPrimes.add(primes.invoke(internalIndex))
            return crawlPrimes(foundPrimes,primes,++internalIndex,clearTimes)
         }
         val nextPrime = primes.invoke(internalIndex)
         foundPrimes.add(nextPrime)

         if(!concPrimesFromList(foundPrimes)){
          foundPrimes.removeLast()
         }

         if(foundPrimes.size < elementBorder) {
            crawlPrimes(foundPrimes, primes, ++internalIndex, clearTimes)
         }

      }else{
         foundPrimes.clear()
         ++internalClearTimes
         crawlPrimes(foundPrimes,primes,internalClearTimes, internalClearTimes)
      }

      return foundPrimes
   }

   fun concPrimesToPrimes(prime1:Int,prime2:Int) =
                 BigInteger(prime1.toString()+prime2.toString()).isProbablePrime(Int.MAX_VALUE)
              && BigInteger(prime2.toString()+prime1.toString()).isProbablePrime(Int.MAX_VALUE)

   fun concPrimesFromList(primes: List<Int>):Boolean{

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