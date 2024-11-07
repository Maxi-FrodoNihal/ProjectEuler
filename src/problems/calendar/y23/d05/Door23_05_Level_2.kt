package problems.calendar.y23.d05

import util.IProblem
import java.io.File

class Door23_05_Level_2 : IProblem {

   override fun getSolution(): String {
      return "81956384"
   }

   class FromToElement(val description: String, val from: Long, val to: Long)
   class MasterLink(val description: String, val linkRangeList: List<LinkRange>)
   class LinkRange(var srcRange: Range, var destRange: Range)

   override fun solve(): String {

      var rawLines = this.readLocalFile("input.txt")
         .lines()

      val seeds = getSeeds(rawLines)
      rawLines = rawLines.subList(2, rawLines.size)

      var masterLinks = splitByElement(rawLines, "").map { list ->
         MasterLink(
            list.get(0),
            list.subList(1, list.size).map { it.split(" ").map(String::toLong) }
               .map { e -> convertToLinkRange(e[1], e[0], e[2]) })
      }

      masterLinks = invertMasterLinks(masterLinks)

      // this part takes seconds because we must iterate from 0 to 81956384 to get the solution
      var returnLocation = -1L

      do {
         ++returnLocation
         val currentSeed = getFromToList(returnLocation, masterLinks).last().to
      } while (seeds.firstOrNull { it.isInRange(currentSeed) } == null)

      return returnLocation.toString()
   }

   private fun getSeeds(rawLines: List<String>): List<Range> {

      val seeds = rawLines.get(0)
         .replace("seeds:", "")
         .split(" ")
         .filter(String::isNotEmpty)
         .map(String::toLong)

      val rangeList = mutableListOf<Range>()

      for (i in seeds.indices step 2) {
         rangeList.add(Range(seeds.get(i), seeds.get(i) + seeds.get(i + 1)))
      }

      return rangeList
   }


   private fun <T> splitByElement(rawLines: List<T>, element: T): List<List<T>> {

      val splitList = mutableListOf<List<T>>()
      var lastIndex = 0

      rawLines.forEachIndexed { index, e ->
         if (e == element) {
            splitList.add(rawLines.subList(lastIndex, index))
            lastIndex = index + 1
         }
      }

      return splitList
   }

   private fun convertToLinkRange(src: Long, dest: Long, step: Long) =
      LinkRange(Range(src, src + step), Range(dest, dest + step))

   private fun getFromToList(seed: Long, masterLinks: List<MasterLink>): List<FromToElement> {

      val fromToList = mutableListOf<FromToElement>()
      var currentKey = seed

      masterLinks.forEach { masterLink ->

         var nextKey = currentKey
         val linkRange = masterLink.linkRangeList.firstOrNull { it.srcRange.isInRange(currentKey) }

         if (linkRange != null) {
            nextKey = linkRange.destRange.getValueWithIndex(linkRange.srcRange.getRangeIndex(currentKey))
         }

         fromToList.add(FromToElement(masterLink.description, currentKey, nextKey))

         currentKey = nextKey
      }

      return fromToList
   }

   private fun invertMasterLinks(masterLinks: List<MasterLink>): List<MasterLink> {

      masterLinks.forEach { masterLink ->
         masterLink.linkRangeList.forEach { linkRange ->

            val copySrcRange = Range(linkRange.srcRange.from, linkRange.srcRange.to)
            val copyDestRange = Range(linkRange.destRange.from, linkRange.destRange.to)

            linkRange.destRange = copySrcRange
            linkRange.srcRange = copyDestRange
         }
      }

      return masterLinks.reversed()
   }
}
