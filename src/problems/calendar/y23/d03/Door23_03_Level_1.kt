package problems.calendar.y23.d03

import util.IProblem
import java.io.File

class Door23_03_Level_1 : IProblem {

   override fun getSolution(): String {
      return "539590"
   }

   override fun solve(): String {

      val inputFile = File(this.javaClass.getResource("input.txt")!!.file)
      val digitGroups = generateDigitGroups(inputFile)

      val signNeighbourDigitGroups = digitGroups.filter { digitGroup ->
         digitGroup.any { digitElement ->
            digitElement.getNeighbours().any(CoordinatesWithNeighbours::isSign)
         }
      }

      return signNeighbourDigitGroups.map(::digitGroupToInt).sum().toString()
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