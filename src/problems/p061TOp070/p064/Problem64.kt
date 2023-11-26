package problems.p061TOp070.p064

import util.IProblem

class Problem64 : IProblem {
   override fun solve(): String {

      var solution = ""
      val sqrtNumber = "5"
      val sqrtPairStream = SqrtPairStream(sqrtNumber)
      val squareList = List(101) { e -> SqareElement(e, e * e) }

      var lastELement = ""

      while (solution.length < 10) {

         val nextPair = sqrtPairStream.getNextPair()
         if (nextPair == ",") {
            solution += nextPair
         } else {

            if (solution.isBlank()) {

               val pair = nextPair.toInt()
               val squareElement = findBestFittingSquareElement(squareList, pair)
               lastELement = (pair - squareElement?.sqare!!).toInt().toString()

               solution += squareElement.number.toString()

               if (lastELement == "0") {
                  break
               }

            } else {

               lastELement += nextPair
               var b = (lastELement.toDouble() / (getSolutionForCalculation(solution) * 20)).toInt()

               var d = 0.0

               do {

                  d = (20 * getSolutionForCalculation(solution) + b) * b
                  --b

               } while (d > lastELement.toDouble())

               solution += b + 1
               lastELement = (lastELement.toDouble() - d).toInt().toString()
            }
         }
      }


      return solution
   }

   private fun getSolutionForCalculation(solution: String) = solution.replace(",", "").toDouble()

   private fun findBestFittingSquareElement(squareList: List<SqareElement>, sqrtNumber: Int): SqareElement? {

      var div = Int.MAX_VALUE
      var foundElement: SqareElement? = null

      for (tmpElement in squareList) {
         val nextDiv = sqrtNumber - tmpElement.sqare

         if (nextDiv !in 0..<div) {
            break;
         }

         div = nextDiv
         foundElement = tmpElement
      }

      return foundElement
   }
}