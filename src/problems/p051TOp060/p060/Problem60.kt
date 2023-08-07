package problems.p051TOp060.p060

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.apache.commons.math3.util.MathUtils
import util.prime.PrimProblem
import util.prime.list.BigPrimeList
import java.math.BigInteger
import java.util.Optional
import java.util.concurrent.atomic.AtomicReference

class Problem60: PrimProblem() {
//   13;5197;5701;6733;8389 (26033)

   private val border = 10000
   private val elementBorder = 5
   private var solutionList = mutableListOf<Int>()
   private val mutex = Mutex()

   override fun getSolution(): String {
      return "26033"
   }

   private suspend fun updateSolution(list:MutableList<Int>){
      mutex.withLock {
         solutionList = list
      }
   }

   override fun solve():String {

      this.primNumbers = BigPrimeList.getInstance().list

      runBlocking {
         (1 until border).map { i ->
            val prim = getOrCalculate(i)
            async(Dispatchers.Default) { work(mutableListOf(prim), i + 1, 2) }
         }.awaitAll()
      }

      return solutionList.sum().toString()
   }

   private suspend fun work(foundPrimes:MutableList<Int>, runningIndex:Int, level: Int){

      if(foundPrimes.size == elementBorder && concPrimesFromList(foundPrimes)){

         if (solutionList.sum() > foundPrimes.sum() || solutionList.isEmpty()){
            updateSolution(foundPrimes.toMutableList())
         }

         foundPrimes.removeLast()
      }

      for(i in runningIndex until border){

         val nextPrime = this.getOrCalculate(i)
         foundPrimes.add(nextPrime)

         if(solutionList.isNotEmpty() && foundPrimes.sum() > solutionList.sum()){
            foundPrimes.removeLast()
            break
         }

         if(concPrimesFromList(foundPrimes)){
            work(foundPrimes, i + 1, level+1)
         }

         foundPrimes.remove(nextPrime)
      }
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

   private fun concPrimesFromList(primes: List<Int>): Boolean {
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