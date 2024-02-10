package problems.calendar.y23.d03

import util.IProblem
import java.io.File

class Door23_03_Level_1 : IProblem {

   override fun solve(): String {

      val rawCoordinates = File(this.javaClass.getResource("input.txt")!!.file)
         .readText()
         .lines().map { it.toList().map(Char::toString) } 
      val kSystem = KSystem(rawCoordinates)
      println(kSystem.get(-4,1))

      val realSystem: MutableList<MutableList<KWithN>> = mutableListOf()

      for((y, line) in rawCoordinates.withIndex()){
         val realSystemLine:MutableList<KWithN> = mutableListOf()
         for((x, element) in line.withIndex()){
            realSystemLine.add(KWithN(x,y,kSystem))
         }
         realSystem.add(realSystemLine)
      }

      return ""
   }

   class KSystem(val system:List<List<String>>){
      fun get(x:Int, y:Int): String? {
         try {
            return system[y][x]
         }catch (ignore :IndexOutOfBoundsException){}
         return null
      }
   }

   class KWithN(val x: Int, val y :Int, val kSystem: KSystem){
      private val rawValue = kSystem.get(x,y)
      private val neighbourCoordinates = listOf(Pair(x-1,y), Pair(x+1,y), Pair(x,y-1), Pair(x,y+1), Pair(x+1,y+1), Pair(x-1,y-1), Pair(x+1,y-1), Pair(x-1,y+1))

      fun getNeighbours() = neighbourCoordinates.map { e -> KWithN(e.first, e.second, kSystem) }.filter { e -> e.rawValue != null }
      fun isDigit() = rawValue?.map { it.isDigit() }?.first()
   }
}