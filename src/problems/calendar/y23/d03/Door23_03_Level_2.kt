package problems.calendar.y23.d03

import util.IProblem
import java.io.File

class Door23_03_Level_2 : IProblem {

   override fun getSolution(): String {
      return "80703636"
   }

   override fun solve(): String {

      val inputFile = File(this.javaClass.getResource("input.txt")!!.file)
      val digitGroups = generateDigitGroups(inputFile)

      val digitGroupsWithGears = digitGroups.filter { digitGroup ->
         digitGroup.any { coordinateWithNeighbour ->
            coordinateWithNeighbour.getNeighbours()
               .any(CoordinatesWithNeighbours::isGear)
         }
      }

      val gearCoordinates = digitGroupsWithGears.map { digitGroup ->
         digitGroup.map { coordinateWithNeighbour ->
            coordinateWithNeighbour.getNeighbours()
               .filter(CoordinatesWithNeighbours::isGear)
               .map { Pair(it.x, it.y) }
         }.flatten()
      }.flatten()
         .toSet()

      return gearCoordinates.parallelStream().map{gearCoordinate ->
         digitGroupsWithGears.filter { digitGroup ->
            digitGroup.any { coordinateWithNeighbour ->
               coordinateWithNeighbour.getNeighbours().any { neighbour ->
                  neighbour.x == gearCoordinate.first &&
                  neighbour.y == gearCoordinate.second
               }
            }
         }.map(::digitGroupToInt)
      }.filter { it.size > 1 }
         .toList()
         .sumOf { it.reduce { acc, num -> acc * num }}
         .toString()
   }

   private fun generateDigitGroups(inputFile: File): MutableList<List<CoordinatesWithNeighbours>> {

      val rawCoordinates = inputFile
         .readText()
         .lines()
         .map { it.toList().map(Char::toString) }
      val dataLocator = DataLocator(rawCoordinates)
      val digitGroups = mutableListOf<List<CoordinatesWithNeighbours>>()

      for (y in rawCoordinates.indices) {
         val innerList = mutableListOf<CoordinatesWithNeighbours>()
         val lineCoordinates = rawCoordinates.get(y).indices
         for (x in lineCoordinates) {

            val coordinateElement = CoordinatesWithNeighbours(x, y, dataLocator)

            if (coordinateElement.isDigit()) {
               innerList.add(coordinateElement)
            }
            if ((!coordinateElement.isDigit() || lineCoordinates.last == x)
               && innerList.isNotEmpty()
            ) {
               digitGroups.add(innerList.toList())
               innerList.clear()
            }
         }
      }

      return digitGroups
   }

   private fun digitGroupToInt(digitGroup:List<CoordinatesWithNeighbours>) =
      digitGroup.mapNotNull(CoordinatesWithNeighbours::rawValue)
          .joinToString("")
          .toInt()
}