package util

import java.io.File

class PrimeList {

   private val list:List<Int>

   init {
      println("Start Loading.....")
      val masterFile = File("C:\\Users\\msc\\Desktop\\Workspaces\\default\\ProjectEuler\\ressources\\Prime\\master.txt")
      list = masterFile.readLines().map { line -> line.split(";").filter { element -> element.isNotEmpty() }.map { element -> element.toInt() } }.flatten().toList()
      println("Done with loading :-)")
   }

   fun isPrime(number:Int):Boolean{

      if(number > list.last()){
         throw IllegalArgumentException("Param to big :(")
      }

      return list.binarySearch(number) >= 0
   }

}