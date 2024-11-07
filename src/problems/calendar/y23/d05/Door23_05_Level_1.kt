package problems.calendar.y23.d05

import util.IProblem
import java.io.File

class Door23_05_Level_1 :IProblem {

   override fun getSolution(): String {
      return "218513636"
   }

   class FromToElement(val description:String , val from:Long, val to:Long)
   class MasterLink(val description: String, val linkRangeList: List<LinkRange>)
   class LinkRange(val srcRange:Range, val destRange:Range)

   override fun solve(): String {

      var rawLines = this.readLocalFile("input.txt")
         .lines()

      val seeds = getSeeds(rawLines)
      rawLines = rawLines.subList(2,rawLines.size)

      val masterLinks = splitByElement(rawLines, "").map { list ->
         MasterLink(
            list.get(0),
            list.subList(1, list.size).map { it.split(" ").map(String::toLong) }
               .map { e -> convertToLinkRange(e[1], e[0], e[2]) })
      }

      return seeds
         .map { seed -> getFromToList(seed, masterLinks) }
         .minOfOrNull { it.last().to }
         .toString()
   }

   private fun getSeeds(rawLines:List<String>) =
      rawLines.get(0)
                .replace("seeds:","")
                .split(" ")
                .filter(String::isNotEmpty)
                .map(String::toLong)


   private fun <T> splitByElement(rawLines:List<T>, element:T): List<List<T>> {

      val splitList = mutableListOf<List<T>>()
      var lastIndex = 0

      rawLines.forEachIndexed{index, e ->
         if(e == element){
            splitList.add(rawLines.subList(lastIndex,index))
            lastIndex=index+1
         }
      }

      return splitList
   }

   private fun convertToLinkRange(src:Long, dest:Long, step:Long) = LinkRange(Range(src, src+step),Range(dest, dest+step))

   private fun getFromToList(seed:Long, masterLinks:List<MasterLink>): List<FromToElement> {

      val fromToList = mutableListOf<FromToElement>()
      var currentKey = seed

      masterLinks.forEach { masterLink ->

         var nextKey = currentKey
         val linkRange = masterLink.linkRangeList.firstOrNull { it.srcRange.isInRange(currentKey) }

         if(linkRange != null){
            nextKey = linkRange.destRange.getValueWithIndex(linkRange.srcRange.getRangeIndex(currentKey))
         }

         fromToList.add(FromToElement(masterLink.description, currentKey, nextKey))

         currentKey = nextKey
      }

      return fromToList
   }
}
