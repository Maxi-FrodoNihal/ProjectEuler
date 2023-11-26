package problems.p061TOp070.p064

class SqrtPairStream(sqrtValue: String) {

   private val digitListIterator: Iterator<String>
   private var commaFlag = true
   private val comma = ","


   init {

      val digitList = sqrtValue.toList().map { e -> e.toString() }

      if (sqrtValue.length % 2 == 1) {
         digitList.addFirst("0")
      }

      digitListIterator = digitList.iterator()
   }

   fun getNextPair(): String {

      var next = "00"

      val nextFromIterator = getNextFromIterator()

      if (nextFromIterator.isNotBlank()) {
         if (nextFromIterator == comma) {
            return nextFromIterator
         }
         next = nextFromIterator
         next += getNextFromIterator()
      }

      return next
   }

   private fun getNextFromIterator(): String {

      if (digitListIterator.hasNext()) {
         return digitListIterator.next()
      } else {
         if (commaFlag) {
            commaFlag = false
            return comma
         }
      }

      return ""
   }
}