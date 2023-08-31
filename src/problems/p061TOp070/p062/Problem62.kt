package problems.p061TOp070.p062

import util.IProblem

class Problem62 : IProblem{

   private val border = 10000
   private val pairs = 5

   override fun getSolution(): String {
      return "127035954683"
   }

   override fun solve() =
      List(border){it.toLong()*it.toLong()*it.toLong()}
         .groupBy{
            it.toString().split("")
               .filter(String::isNotBlank)
               .map(String::toInt)
               .sorted()
            }
         .entries.filter { it.value.size == pairs }
         .map { it.value }
         .flatten()
         .min()
         .toString()
}