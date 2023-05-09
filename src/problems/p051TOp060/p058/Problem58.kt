package problems.p051TOp060.p058

import util.IProblem

class Problem58 : IProblem {
   override fun solve(): String {

      val size = 3
      val middle = MatrixPoint(size/2,size/2)
      val stream = NumberStream()

      val matrix = QMatrix(size)
      fillSpiral(matrix,middle, stream)
      matrix.expand()
      fillSpiral(matrix,MatrixPoint(matrix.size()-2, matrix.size()-2), stream)

      return matrix.toString()
   }

   private fun fillSpiral(matrix: QMatrix, startPoint: MatrixPoint, stream: NumberStream): QMatrix {

      val middle = matrix.size() / 2
      val middlePoint = MatrixPoint(middle, middle);

      var changePoint = startPoint;
      var startIndex = startPoint.x-1

      if(middlePoint == startPoint) {
         matrix.set(middlePoint, stream)
         startIndex = middlePoint.x
      }

      val directionVector =
         listOf(
            Direction.NORTH,
            Direction.WEST,
            Direction.SOUTH,
            Direction.EAST
         )

      for (i in startIndex until middle + 1) {
         changePoint = matrix.set(changePoint, Direction.EAST, 1, stream)
         val times = i * 2
         for (direction in directionVector) {
            changePoint = if (direction == Direction.NORTH) {
               matrix.set(changePoint, direction, times - 1, stream)
            } else {
               matrix.set(changePoint, direction, times, stream)
            }
         }
      }

      return matrix
   }
}