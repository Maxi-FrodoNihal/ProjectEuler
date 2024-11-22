package problems.calendar.y22.d05

import util.IProblem

class Door22_05_Level_1 : IProblem {

   override fun getSolution(): String {
      return "WCZTHTMPS"
   }

   override fun solve(): String {

      val listPair = this.readLocalFile("input.txt").lines().partition { it.startsWith("move") }

      val instructions =
         listPair.first.map { it.split(" ") }.map { Instruction(it[1].toInt(), it[3].toInt(), it[5].toInt()) }
      val maxCargos = listPair.second.maxOf { it.length }
      val stackRepresentation = listPair.second.filter { it.isNotEmpty() }.map { fillWithEmptyCargo(it, maxCargos) }

      val stackList = readCargoStacksFromLines(stackRepresentation)

      instructions.forEach { doInstruction(it, stackList) }

      return stackList.joinToString("") { it.peek() }
   }

   private fun doInstruction(instruction: Instruction, stackList: List<CargoStack>) {
      val elements = getElementsFromStack(instruction.amount, instruction.from, stackList)
      pushElementsToStack(elements, instruction.to, stackList);
   }

   private fun pushElementsToStack(elements: List<String>, stackID: Int, stackList: List<CargoStack>) {
      val wantedStack = stackList.first { it.locationID == stackID }
      elements.forEach(wantedStack::push)
   }

   private fun getElementsFromStack(amount: Int, stackID: Int, stackList: List<CargoStack>): List<String> {

      val wantedStack = stackList.first { it.locationID == stackID }
      val elements = mutableListOf<String>()

      for (i in 0 until amount) {
         elements.add(wantedStack.pop())
      }

      return elements
   }

   private fun readCargoStacksFromLines(lines: List<String>): List<CargoStack> {

      val stackList = mutableListOf<CargoStack>()

      for ((i, line) in lines.reversed().withIndex()) {
         if (i == 0) {
            stackList.addAll(line.split("  ").map(String::trim).map(String::toInt).map { CargoStack(it) })
         } else {
            line.split(" ")
               .map { it.replace("[", "").replace("]", "").trim() }
               .forEachIndexed { index, s ->
                  if (s.isNotEmpty()) {
                     stackList[index].push(s)
                  }
               }
         }
      }

      return stackList;
   }

   private fun fillWithEmptyCargo(line: String, max: Int): String {

      if (!line.contains("]") && !line.contains("[")) {
         return line
      }

      val emptySpaceLetterList = fillWithEmptySpace(line, max)

      return emptySpaceLetterList.onEachIndexed { index, s ->
         if (index % 4 == 0 && s != "[") {
            emptySpaceLetterList[index] = "["
         } else if (index % 4 == 2 && s != "]") {
            emptySpaceLetterList[index] = "]"
         }
      }.joinToString("")
         .replace("[]", "[${CargoStack.emptySign}]")
         .replace("][", "] [")
   }

   private fun fillWithEmptySpace(line: String, max: Int): MutableList<String> {

      val emptySpaceList: MutableList<String> = line.map { it.toString().trim() }.toMutableList()

      while (emptySpaceList.size < max) {
         emptySpaceList.add("")
      }

      return emptySpaceList
   }
}