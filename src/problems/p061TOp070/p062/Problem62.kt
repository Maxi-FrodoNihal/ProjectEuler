package problems.p061TOp070.p062

import util.IProblem

class Problem62 : IProblem{

   override fun getSolution(): String {
      return "127035954683"
   }

   override fun solve(): String {

      val cubeList = MutableList(10000){CubeElement(it.toLong()*it.toLong()*it.toLong())}
      var solutionList:List<CubeElement> ?= null

      for(cubeElement in cubeList){

         val wantedList = cubeList.filter { e -> e.qSum == cubeElement.qSum && e.digitList == cubeElement.digitList }

         if (wantedList.size == 5) {
            solutionList = wantedList
            break
         }
      }

      return solutionList?.minOfOrNull(CubeElement::value).toString()
   }

   private class CubeElement(val value:Long){
       val digitList = value.toString().split("").filter(String::isNotBlank).map(String::toInt).sorted().toList()
       val qSum = value.toString().split("").filter(String::isNotBlank).map(String::toInt).sum()
   }
}