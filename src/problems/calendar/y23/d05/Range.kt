package problems.calendar.y23.d05

class Range(private val from:Long, private val to: Long) {

   fun isInRange(value:Long) = value in from..to

   fun getRangeIndex(value:Long): Long {
      if(isInRange(value)){
         return value-from
      }
      return -1
   }

   fun getValueWithIndex(index:Long) = from + index
}