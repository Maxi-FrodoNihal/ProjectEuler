package problems.p061TOp070.p061

import util.IProblem

class Problem61:IProblem {

   override fun getSolution(): String {
      return "28684"
   }

   private class ValueAndMarker(var value:Int, var parentMarker:Int)
   private class VAndMGroupElement(val value:Int){
      val group = mutableSetOf<ValueAndMarker>()
   }

   private fun triangle(n:Int)   = n*(n+1)/2
   private fun square(n:Int)     = n*n
   private fun pentagonal(n:Int) = n*(3*n-1)/2
   private fun hexagonal(n:Int)  = n*(2*n-1)
   private fun heptagonal(n:Int) = n*(5*n-3)/2
   private fun octagonal(n:Int)  = n*(3*n-2)

   override fun solve(): String {

      val metaList = mutableListOf<VAndMGroupElement>()

      addTogether(metaList,runAllFourDigits(this::triangle  ,3))
      addTogether(metaList,runAllFourDigits(this::square    ,4))
      addTogether(metaList,runAllFourDigits(this::pentagonal,5))
      addTogether(metaList,runAllFourDigits(this::hexagonal ,6))
      addTogether(metaList,runAllFourDigits(this::heptagonal,7))
      addTogether(metaList,runAllFourDigits(this::octagonal ,8))

      val solutionList = mutableListOf<ValueAndMarker>()

      findSolutionOuter(solutionList, metaList)

      return solutionList.map(ValueAndMarker::value).sum().toString()
   }

   private fun findSolutionOuter(solutionList: MutableList<ValueAndMarker>, metaList: MutableList<VAndMGroupElement>){
      outerloop@
      for (metaElement in metaList) {
         for(tmpIndexAndValue in metaElement.group){
            findSolutionInner( solutionList.also { it.add(tmpIndexAndValue) }, metaList)
            if (solutionList.size == 6) {
               break@outerloop
            }
            solutionList.clear()
         }
      }
   }

   private fun findSolutionInner(solutionList: MutableList<ValueAndMarker>, metaList: List<VAndMGroupElement>){

      val suffix = solutionList.last().value.toString().substring(2, 4)
      val praefix = if(solutionList.size == 5) solutionList.first().value.toString().substring(0,2) else ""

      val nextMetaElements = metaList.filter { e ->
            e.value.toString().substring(0, 2) == suffix
           && e.group.map(ValueAndMarker::parentMarker).subtract(solutionList.map(ValueAndMarker::parentMarker).toSet()).isNotEmpty()
           && (praefix.isEmpty() || (praefix.isNotEmpty() && e.value.toString().substring(2,4) == praefix))
      }

      outerloop@
      for(metaElement in nextMetaElements){
         for(tmpIndexAndValue in metaElement.group){
            if(!solutionList.map{ e -> e.parentMarker }.contains(tmpIndexAndValue.parentMarker)) {

               val copyOfSolutionList = mutableListOf<ValueAndMarker>()
               copyOfSolutionList.addAll(solutionList)

               findSolutionInner(solutionList.also { it.add(tmpIndexAndValue) }, metaList)
               if (solutionList.size == 6) {
                  break@outerloop
               }
               solutionList.clear()
               solutionList.addAll(copyOfSolutionList)
            }
         }
      }
   }

   private fun addTogether(metaList:MutableList<VAndMGroupElement>, subList:List<ValueAndMarker>){

      for (subItem in subList) {

         val foundLElement = metaList.filter { e -> e.value == subItem.value }

         if(foundLElement.isEmpty()){
            val lElement = VAndMGroupElement(subItem.value)
            lElement.group.add(subItem)
            metaList.add(lElement)
         }else{
            foundLElement.first().group.add(subItem)
         }
      }
   }

   private fun runAllFourDigits(morph: (Int)->Int, parentMarker: Int):MutableList<ValueAndMarker>{

      var index = 1
      var value = 0
      val relevantNumbers = mutableListOf<ValueAndMarker>()

      while (value < 9999){

         value = morph(index)

         if(value in 1000..9999){
            relevantNumbers.add(ValueAndMarker(value, parentMarker))
         }

         ++index
      }

      return relevantNumbers
   }
}