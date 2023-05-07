package problems.p051TOp060.p058

class QMatrix(size: Int) {

   private var rawMatrix: MutableList<MutableList<Int>> = MutableList(size) { MutableList(size) { 0 } }

   fun set(point: MatrixPoint, value: Int): MatrixPoint {
      rawMatrix.get(point.x).set(point.y, value)
      return point
   }

   fun set(point: MatrixPoint, direction: Direction, value: Int): MatrixPoint =
      set(direction.change.invoke(point), value)

   fun set(point: MatrixPoint, direction: Direction, times: Int, stream: NumberStream): MatrixPoint {

      var internPoint = point

      for (i in 0 until times) {
         internPoint = set(internPoint, direction, stream.next())
      }

      return internPoint
   }

   fun size(): Int = rawMatrix.size

   fun getMaxValue(): Int = rawMatrix.flatten().max()

   override fun toString(): String {

      var returnString = ""

      rawMatrix.forEach { innerList ->
         innerList.forEach { e ->
            val eString = e.toString().padStart(this.getMaxValue().toString().length, '0')
            returnString += " $eString "
         }
         returnString += "\n"
      }

      return returnString
   }

   enum class Direction(val change: (MatrixPoint) -> (MatrixPoint)) {
      NORTH({ e -> MatrixPoint(e.x - 1, e.y) }),
      SOUTH({ e -> MatrixPoint(e.x + 1, e.y) }),
      EAST({ e -> MatrixPoint(e.x, e.y + 1) }),
      WEST({ e -> MatrixPoint(e.x, e.y - 1) });
   }
}