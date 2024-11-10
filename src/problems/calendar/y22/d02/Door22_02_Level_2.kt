package problems.calendar.y22.d02

import util.IProblem

class Door22_02_Level_2 : IProblem {

   override fun getSolution() = "11186"

   override fun solve(): String {

      return this.readLocalFile("input.txt")
         .lines()
         .sumOf { line ->

            var sum = 0

            val rawInput = line.split(" ")
            val enemyInput = RPC.getRPCByString(rawInput[0])
            val output = Output.getOutputByString(rawInput[1])

            if(output != null && enemyInput != null){

              val ourInput = when(output){
                  Output.DRAW -> enemyInput
                  Output.WIN -> enemyInput.getNemesis()
                  Output.LOSE -> RPC.values()
                                    .dropWhile { it == enemyInput }
                                    .dropWhile { it == enemyInput.getNemesis() }
                                    .first()
               }

               sum += ourInput.score
               sum += output.score
            }

            sum

         }.toString()
   }
   private enum class RPC(val codeEnemy: String, val score: Int) {

      ROCK("A",  1),
      PAPER("B",  2),
      SCISSORS("C",  3);

      companion object {
         fun getRPCByString(letter: String): RPC? {
            return RPC.values().firstOrNull { it.codeEnemy == letter }
         }
      }

      fun getNemesis():RPC{
         return when(this){
            ROCK -> PAPER
            PAPER -> SCISSORS
            SCISSORS -> ROCK
         }
      }
   }

   private enum class Output(val score: Int, val code:String) {

      WIN(6, "Z"),
      LOSE(0, "X"),
      DRAW(3, "Y");

      companion object {
         fun getOutputByString(letter: String): Output? {
            return Output.values().firstOrNull { it.code == letter }
         }
      }
   }
}

