package problems.p051TOp060.p060

import util.corutine.CoCallbacker
import util.corutine.CoElement
import util.corutine.CoMaster
import util.corutine.CoNexter
import util.prime.PrimProblem
import java.math.BigInteger
import java.util.*

class Problem60Co:PrimProblem(),CoNexter<List<Int>>, CoCallbacker<Optional<List<Int>>>{
//   607;3;37;276517;495181 (wrong)
   val border = 50000
   val elementBorder = 5
   var nextElementsIterator: Iterator<Co60Element>? = null
   val coRutinesAmount = 12
   var solutionList = mutableListOf<Int>()

   override fun solve(): String {
      this.getOrCalculate(border)
      val master = CoMaster<List<Int>>(coRutinesAmount,this,this)

     val nextElements = mutableListOf<Co60Element>()

      for (i in 0..border ){
         nextElements.add(Co60Element(this,border,elementBorder, mutableListOf<Int>(),i,master))
      }
      nextElementsIterator = nextElements.iterator()

      master.run()

      return solutionList.joinToString(";")
   }


   override fun callback(callbacdkElement: Optional<List<Int>>) {
      callbacdkElement.ifPresent(solutionList::addAll)
   }

   override fun next(): Optional<CoElement<List<Int>>> {
      return Optional.ofNullable(nextElementsIterator?.next())
   }

   class Co60Element(private val primProblem:PrimProblem, private val border:Int, private val elementBorder:Int, private var foundPrimes: MutableList<Int>, private val index:Int, private val callbacker: CoCallbacker<List<Int>>): CoElement<List<Int>>{

      override fun runInCorutine() {

            if(foundPrimes.isEmpty()){
               foundPrimes.add(primProblem.getOrCalculate(index))
               println(foundPrimes.last())
            }

            innerMethod(index,foundPrimes).ifPresent{e->foundPrimes = e}

            if(concPrimesFromList(foundPrimes) && foundPrimes.size == elementBorder){
               this.getCallbacker().callback(foundPrimes)
            }else{
               foundPrimes.clear()
            }
      }

      override fun getCallbacker(): CoCallbacker<List<Int>> {
         return callbacker
      }

      private fun innerMethod(externIndex:Int, foundPrimes:MutableList<Int>): Optional<MutableList<Int>> {

         for (j in 0..border ){
            if(externIndex != j){
               foundPrimes.add(primProblem.getOrCalculate(j))

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
}