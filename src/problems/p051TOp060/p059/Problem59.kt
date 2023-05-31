package problems.p051TOp060.p059

import kotlinx.coroutines.*
import util.IProblem
import java.io.File
import java.math.BigInteger
import kotlin.streams.toList

class Problem59:IProblem{

   private val bitLenght = 8
   private val coroutinesAmount = 1000

   override fun getSolution(): String {
      return "129448"
   }

   override fun solve(): String {

      var readableString = ""
      val cypherText = File(javaClass.getResource("0059_cipher.txt").file).readText()
      val cypherBStrings = cypherText.split(",").map { e-> this.intToBString(e.toInt()) }.toList()

      val permuKeys = permuKeys()
      val workList = permuKeys.chunked(permuKeys.size / coroutinesAmount)

      runBlocking {

         val mutableList = mutableListOf<Deferred<List<String>>>();

         workList.forEach{keys ->
            mutableList.add( async(Dispatchers.Default) {
               getRedableStrings(keys, cypherBStrings)
            })
         }

         while (readableString.isBlank()) {
            readableString = mutableList.find (::isCompletedAndNotEmpty)?.getCompleted()?.find(String::isNotBlank).orEmpty()
            mutableList.removeIf (::isCompletedAndEmpty)
         }

         mutableList.forEach (Job::cancel)
      }

      return readableString.chars().sum().toString()
   }

   private fun isCompletedAndEmpty(list:Deferred<List<String>>)=list.isCompleted && list.getCompleted().find { e -> e.isNotBlank() }.orEmpty().isEmpty()
   private fun isCompletedAndNotEmpty(list:Deferred<List<String>>)=list.isCompleted && list.getCompleted().find { e -> e.isNotBlank() }.orEmpty().isNotBlank()

   private fun getRedableStrings(keys:List<String>, cypherBStrings:List<String>):List<String>  {

      val readableStrings = mutableListOf<String>()

      for (key in keys) {
         val bkey = key.chars().toList().joinToString("") { e -> this.intToBString(e) }
         val totalCypherBytes = cypherBStrings.joinToString("")

         val decryptRaw = xor(totalCypherBytes, expandKeyBytes(bkey, totalCypherBytes.length))
         val wantedString = convertToStrByteToString(decryptRaw, cypherBStrings.size)

         if(wantedString.contains("the ", true) && wantedString.contains("is ", true)){
            readableStrings.add(wantedString)
         }else{
            readableStrings.add("")
         }
      }

      return readableStrings
   }

   private fun permuKeys():List<String> {
      val pool = "abcdefghijklmnopqrstuvwxyz".split("").filter { e-> e.isNotBlank() }.toList()
      val returnList = mutableListOf<String>()

      for (i in pool.indices) {
         for (j in pool.indices) {
            for (k in pool.indices) {
               returnList.add(pool.get(i)+pool.get(j)+pool.get(k))
            }
         }
      }

      return  returnList
   }

   private fun convertToStrByteToString(strByte:String, chunks: Int):String{

      var runIndex = 0
      var wordString = "";

      for(i in 0 until  chunks){
         wordString+=Char(BigInteger(strByte.substring(runIndex, runIndex+bitLenght), 2).toInt()).toString()
         runIndex+=bitLenght
      }

      return wordString;
   }

   private fun expandKeyBytes(keyBytes:String, targetLength:Int):String{

      var expandKey = ""

      while (expandKey.length < targetLength){
         expandKey+=keyBytes
      }

      return expandKey.substring(0,targetLength)
   }

   private fun xor(strBytes1:String, strBytes2:String) = BigInteger(strBytes1,2).xor(BigInteger(strBytes2,2)).toString(2).padStart(strBytes1.length,'0')

   private fun intToBString(bInt: Int)= bInt.toString(2).padStart(bitLenght,'0')
}