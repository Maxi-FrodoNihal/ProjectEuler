package problems.p051TOp060.p058

class QMatrix(size: Int) {

   private val rawMatrix: MutableList<MutableList<Int>> = MutableList(size) { MutableList(size) { 0 } }

   fun set(point: MatrixPoint, stream: NumberStream): MatrixPoint {
      rawMatrix.get(point.x).set(point.y, stream.next())
      return point
   }

   fun set(point: MatrixPoint, direction: Direction, stream: NumberStream): MatrixPoint =
      set(direction.change.invoke(point), stream)

   fun set(point: MatrixPoint, direction: Direction, times: Int, stream: NumberStream): MatrixPoint {

      var internPoint = point

      for (i in 0 until times) {
         internPoint = set(internPoint, direction, stream)
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

   fun expand(){

      val newSize = this.size()+2;

      rawMatrix.forEach { e ->
         e.add(0, 0)
         e.add(0)
      }

      rawMatrix.add(0, MutableList(newSize){0})
      rawMatrix.add( MutableList(newSize){0})
   }

   fun getDiagonalElements():Set<Int>{

      val diagonalElements = mutableSetOf<Int>()

      for(i in 0 until this.size()){
         diagonalElements.add(rawMatrix.get(i).get(i));
         diagonalElements.add(rawMatrix.get(i).get(size()-1-i));
      }

      return diagonalElements;
   }

   fun getAllElements() = rawMatrix.flatten().toList()
}