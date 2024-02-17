package problems.calendar.y23.d03

class DataLocator(val system:List<List<String>>){
   fun get(x:Int, y:Int): String? {
      try {
         return system[y][x]
      }catch (ignore :IndexOutOfBoundsException){}
      return null
   }
}