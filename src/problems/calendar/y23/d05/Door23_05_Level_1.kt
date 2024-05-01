package problems.calendar.y23.d05

import util.IProblem
import java.io.File

class Door23_05_Level_1 :IProblem {

   override fun getSolution(): String {
      return "218513636"
   }

   class FromToElement(val description:String , val from:Long, val to:Long)

   class MasterMap(val description: String, val map: List<LinkRange>)
   class LinkRange(val srcRange:Range, val destRange:Range)

   override fun solve(): String {

      var rawLines = File(this.javaClass.getResource("input.txt")!!.file)
         .readText()
         .lines()

      val seeds = getSeeds(rawLines)
      rawLines = rawLines.subList(2,rawLines.size)

      val masterMaps = splitByElement(rawLines, "").map { list ->
         MasterMap(
            list.get(0),
            list.subList(1, list.size).map { e -> e.split(" ").map(String::toLong) }
               .map { e -> convertToLinkRange(e[1], e[0], e[2]) })
      }

      return seeds
         .map { seed -> convertToFromToList(seed, masterMaps) }
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

      rawLines.forEachIndexed{i, e ->
         if(e == element || i == rawLines.size-1){
            splitList.add(rawLines.subList(lastIndex,i))
            lastIndex=i+1
         }
      }

      return splitList
   }

   private fun convertToLinkRange(src:Long, dest:Long, step:Long) = LinkRange(Range(src, src+step),Range(dest, dest+step))

   private fun convertToFromToList(seed:Long, masterMaps:List<MasterMap>): List<FromToElement> {

      val fromToList = mutableListOf<FromToElement>()
      var currentKey = seed

      masterMaps.forEach { map ->

         var nextKey = currentKey
         val linkRange = map.map.firstOrNull { it.srcRange.isInRange(currentKey) }

         if(linkRange != null){
            nextKey = linkRange.destRange.getValueWithIndex(linkRange.srcRange.getRangeIndex(currentKey))
         }

         fromToList.add(FromToElement(map.description, currentKey, nextKey))

         currentKey = nextKey
      }

      return fromToList
   }
}
