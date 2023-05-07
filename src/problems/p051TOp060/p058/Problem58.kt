package problems.p051TOp060.p058

import util.IProblem

class Problem58 : IProblem {
   override fun solve(): String {

      val matrix = QMatrix(11)
      fillSpiral(matrix)

      return matrix.toString()
   }

   private fun fillSpiral(matrix: QMatrix): QMatrix {

      val stream = NumberStream()
      val middle = matrix.size() / 2
      val middlePoint = MatrixPoint(middle, middle);

      var changePoint = middlePoint;
      matrix.set(middlePoint, stream.next())

      val directionVector =
         listOf(
            QMatrix.Direction.NORTH,
            QMatrix.Direction.WEST,
            QMatrix.Direction.SOUTH,
            QMatrix.Direction.EAST
         )

      for (i in 1 until middle + 1) {
         changePoint = matrix.set(changePoint, QMatrix.Direction.EAST, 1, stream)
         val times = i * 2
         for (direction in directionVector) {
            changePoint = if (direction == QMatrix.Direction.NORTH) {
               matrix.set(changePoint, direction, times - 1, stream)
            } else {
               matrix.set(changePoint, direction, times, stream)
            }
         }
      }

      return matrix
   }
}