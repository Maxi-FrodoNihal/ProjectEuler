package util.primelist

import net.lingala.zip4j.ZipFile
import java.io.File

class PrimeList {

   private val list:List<Int>

   init {
      println("Start Loading.....")
      val tempDir = kotlin.io.path.createTempDirectory("tempDir").toFile()
      val firstZipFile = File(javaClass.getResource("data/master.zip.001").file)
      val zipFile = ZipFile(firstZipFile)
      zipFile.extractAll(tempDir.path)
      val masterFile = tempDir.listFiles().first { e -> e.name.contains("master") }
      list = masterFile.readLines().map { line -> line.split(";").filter { element -> element.isNotEmpty() }.map { element -> element.toInt() } }.flatten().toList()
      masterFile.delete()
      tempDir.delete()
      println("Done with loading :-)")
   }

   fun isPrime(number:Int):Boolean{

      if(number > list.last()){
         throw IllegalArgumentException("Param to big :(")
      }

      return list.binarySearch(number) >= 0
   }
}