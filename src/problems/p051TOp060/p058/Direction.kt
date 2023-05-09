package problems.p051TOp060.p058

enum class Direction(val change: (MatrixPoint) -> (MatrixPoint)) {
   NORTH({ e -> MatrixPoint(e.x - 1, e.y) }),
   SOUTH({ e -> MatrixPoint(e.x + 1, e.y) }),
   EAST({ e -> MatrixPoint(e.x, e.y + 1) }),
   WEST({ e -> MatrixPoint(e.x, e.y - 1) });
}