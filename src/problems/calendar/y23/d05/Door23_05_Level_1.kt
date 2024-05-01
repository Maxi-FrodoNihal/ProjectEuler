package problems.calendar.y23.d05

import org.apache.commons.collections4.CollectionUtils
import org.apache.commons.lang3.StringUtils
import util.IProblem
import java.io.File

class Door23_05_Level_1 :IProblem {

   class FromToElement(val description:String , val from:Long, val to:Long)

   class MasterMap(val description: String, val map: Map<Long, Long>)
   class MapSection(val description:String, val mapElements:List<MapElement>)
   class MapElement(val dest:Long, val src:Long, val step:Long)

   override fun solve(): String {

      var rawLines = File(this.javaClass.getResource("input.txt")!!.file)
         .readText()
         .lines()

      val seeds = getSeeds(rawLines)
      rawLines = rawLines.subList(2,rawLines.size)

      val mapSections = splitByElement(rawLines, "").map { list ->
         MapSection(
            list.get(0),
            list.subList(1, list.size).map { e -> e.split(" ").map(String::toLong) }
               .map { e -> MapElement(e[0], e[1], e[2]) })
      }

      val masterMaps = mapSections.map { e -> MasterMap(e.description, mapElementsToMasterMap(e.mapElements)) }

      val fromToLists = seeds.map { seed -> convertToFromToList(seed, masterMaps) }

      return fromToLists.map { it.last() }.minBy { it.to }.to.toString()
   }

   private fun getSeeds(rawLines:List<String>): List<Long> {

      val seeds = mutableListOf<Long>()

      if(CollectionUtils.isNotEmpty(rawLines)){
         seeds.addAll(rawLines.get(0)
                              .replace("seeds:","")
                              .split(" ")
                              .filter(StringUtils::isNotEmpty)
                              .map(String::toLong))
      }

      return seeds
   }

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

   private fun convertMapElementToSrcDestLists(element:MapElement): Pair<List<Long>, List<Long>> {

      val srcList = List(element.step.toInt()) { index -> element.src + index }
      val destList = List(element.step.toInt()) { index -> element.dest + index }

      return Pair(srcList, destList)
   }

   private fun mapElementsToMasterMap(mapElements: List<MapElement>):Map<Long,Long>{

      val map = mutableMapOf<Long,Long>()

      val srcList = mapElements.map(::convertMapElementToSrcDestLists).flatMap {  e -> e.first }
      val destList = mapElements.map(::convertMapElementToSrcDestLists).flatMap {  e -> e.second }

      srcList.forEachIndexed { i, e -> map.put(e, destList.get(i))  }

      return map
   }

   private fun convertToFromToList(seed:Long, masterMaps:List<MasterMap>): List<FromToElement> {

      val fromToList = mutableListOf<FromToElement>()
      var currentKey = seed

      masterMaps.forEach { map ->

         val nextKey = map.map.getOrElse(currentKey){currentKey}

         fromToList.add(FromToElement(map.description, currentKey, nextKey))

         currentKey = nextKey
      }

      return fromToList
   }
}
