package problems.p051TOp060.p059

import util.IProblem
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.experimental.xor
import kotlin.streams.toList

class Problem59:IProblem{


   override fun solve(): String {

      val test = "HALLO"
      val testListOfBytes = test.chars().toList().map { e -> BElement(e)};
      val key:List<Int> = "xx".chars().toList();

      println("Testword: $test");
      println("Code key: "+ key.map { e->Char(e) }).toString()
      println("Testword singe bytes: "+testListOfBytes.joinToString("") { e -> e.bString });
      println("Code key bytes: "+ key.map { e->e.toString(2) })

      val totalTestWordBytes = testListOfBytes.joinToString("") { e -> e.bString };
      val totalKeyBytes =
         expandKeyBytes(key.map { e -> e.toString(2) }.toList().joinToString(""), totalTestWordBytes.length);

      println("Testword full bytes: $totalTestWordBytes")
      println("Code key full bytes: $totalKeyBytes")



      return ""
   }

   private fun expandKeyBytes(keyBytes:String, targetLength:Int):String{

      var expandKey = ""

      while (expandKey.length < targetLength){
         expandKey+=keyBytes
      }

      return expandKey.substring(0,targetLength)
   }

   // Own xor is needed

   private class BElement(val bInt: Int){
      val bString = bInt.toString(2)
      val length:Int = bString.length
   }
}