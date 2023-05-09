package problems.p051TOp060.p058

import util.PrimProblem

class Problem58 : PrimProblem() {
   override fun solve(): String {

      val size = 3
      val middle = MatrixPoint(size/2,size/2)
      val stream = NumberStream()
      val matrix = QMatrix(size)

      matrix.set(middle,stream)
      fillSpiral(matrix,MatrixPoint(matrix.size()-2, matrix.size()-2), stream)

      var dioFactor = 0.0
      var counter = 0

      do {
         matrix.expand()
         val size = matrix.size()
         fillSpiral(matrix,MatrixPoint(matrix.size()-2, matrix.size()-2), stream)

         val diagonalPrimCount = matrix.getDiagonalElements().count(::isPrim)

         dioFactor = diagonalPrimCount.toDouble()/matrix.getDiagonalElements().size.toDouble()

            println("$dioFactor $size")

         ++counter

      }while (dioFactor>0.10)

      return matrix.size().toString()
   }

   private fun fillSpiral(matrix: QMatrix, startPoint: MatrixPoint, stream: NumberStream) {

      val times = matrix.size()-1
      var changePoint = startPoint;

      val directionVector =
         listOf(
            Direction.NORTH,
            Direction.WEST,
            Direction.SOUTH,
            Direction.EAST
         )

         changePoint = matrix.set(changePoint, Direction.EAST, 1, stream)

         for (direction in directionVector) {
            changePoint = if (direction == Direction.NORTH) {
               matrix.set(changePoint, direction, times - 1, stream)
            } else {
               matrix.set(changePoint, direction, times, stream)
            }
         }
   }
}