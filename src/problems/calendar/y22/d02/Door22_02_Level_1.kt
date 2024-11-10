package problems.calendar.y22.d02

import util.IProblem

class Door22_02_Level_1 : IProblem {

   override fun getSolution() = "11906"

   override fun solve(): String {

      return this.readLocalFile("input.txt")
         .lines()
         .sumOf { line ->

            var sum = 0

            val rawInput = line.split(" ")
            val userInput = RPC.getRPCByString(rawInput[1])
            val enemyInput = RPC.getRPCByString(rawInput[0])

            if (userInput != null && enemyInput != null) {
               sum += userInput.score
               sum += RPC.versus(userInput, enemyInput).score
            }

            sum

         }.toString()
   }
   private enum class RPC(val codeEnemy: String, val codeOwn: String, val score: Int) {

      ROCK("A", "X", 1),
      PAPER("B", "Y", 2),
      SCISSORS("C", "Z", 3);

      companion object {
         fun getRPCByString(letter: String): RPC? {
            return RPC.values().firstOrNull { it.codeEnemy == letter || it.codeOwn == letter }
         }

         fun versus(input1: RPC, input2: RPC): Output {
            if (input1 == input2) {
               return Output.DRAW
            }
            if (input1 == ROCK && input2 == SCISSORS
               || input1 == PAPER && input2 == ROCK
               || input1 == SCISSORS && input2 == PAPER
            ) {
               return Output.WIN
            }
            return Output.LOSE
         }
      }
   }

   private enum class Output(val score: Int) {
      WIN(6),
      LOSE(0),
      DRAW(3);
   }
}

