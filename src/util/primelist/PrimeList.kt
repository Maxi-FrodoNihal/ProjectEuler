package util.primelist

import net.lingala.zip4j.ZipFile
import net.lingala.zip4j.exception.ZipException
import net.lingala.zip4j.io.inputstream.SplitFileInputStream
import net.lingala.zip4j.model.ZipModel
import net.lingala.zip4j.util.UnzipUtil
import org.apache.commons.io.IOUtils
import java.io.File
import java.nio.charset.Charset

fun main(){
   PrimeList()
}

class PrimeList {

   private val list:List<Int> = listOf()

   init {
      println("Start Loading.....")

      val dataDirectory = File(javaClass.getResource("data/master.zip.001").file)
      var masterFile:File? = null;
      try {

         val zipModel = ZipModel()
         zipModel.zipFile = dataDirectory
//         zipModel.isSplitArchive = true

         val createSplitInputStream: SplitFileInputStream = UnzipUtil.createSplitInputStream(zipModel)
         ZipFile(null)
         val testString = IOUtils.toString(createSplitInputStream, Charset.forName("UTF-8"))

         println("Hallo")

      } catch (e: ZipException) {
         e.printStackTrace()
      }

//      val masterFile = File("C:\\Users\\msc\\Desktop\\Workspaces\\default\\ProjectEuler\\ressources\\Prime\\master.txt")
//      list = masterFile.readLines().map { line -> line.split(";").filter { element -> element.isNotEmpty() }.map { element -> element.toInt() } }.flatten().toList()
      println("Done with loading :-)")
   }

   fun isPrime(number:Int):Boolean{

      if(number > list.last()){
         throw IllegalArgumentException("Param to big :(")
      }

      return list.binarySearch(number) >= 0
   }

}