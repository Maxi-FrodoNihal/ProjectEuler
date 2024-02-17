package problems.calendar.y23.d03

class CoordinatesWithNeighbours(val x: Int, val y :Int, private val dataLocator: DataLocator){
   val rawValue = dataLocator.get(x,y)
   private val neighbourCoordinates =
      listOf(Pair(x-1,y),
         Pair(x+1,y),
         Pair(x,y-1),
         Pair(x,y+1),
         Pair(x+1,y+1),
         Pair(x-1,y-1),
         Pair(x+1,y-1),
         Pair(x-1,y+1))

   fun getNeighbours() = neighbourCoordinates
      .map {  CoordinatesWithNeighbours(it.first, it.second, dataLocator) }
      .filter { e -> e.rawValue != null }

   fun isDigit() = rawValue?.map { it.isDigit() }?.first()?: false
   fun isSign() = !isDigit() && rawValue != "."
   fun isGear() = rawValue == "*"
}