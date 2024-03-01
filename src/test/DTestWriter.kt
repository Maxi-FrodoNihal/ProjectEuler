package test

import problems.PathSlave
import util.DLoader
import util.IProblem
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.util.*


fun main() {
   DTestWriter().generateTestFile()
   println("Ist im Clipboard. :)")
}

class DTestWriter {
   private val problemKinder = setOf("Problem18")

   fun generateTestFile() {
      val allProblems = DLoader.loadInterfaceObjectsFromT(
         PathSlave::class.java, IProblem::class.java
      )
      var strBu = StringBuffer()

      strBu = doTop(strBu, allProblems)
      strBu = doMiddle(strBu, allProblems)
      strBu = doEnd(strBu)

      val selection = StringSelection(strBu.toString())
      val clipboard = Toolkit.getDefaultToolkit().systemClipboard
      clipboard.setContents(selection, selection)
   }

   private fun doTop(strBu: StringBuffer, iProblems: List<IProblem>): StringBuffer {
      val importClasses =
         iProblems.stream().map { e: IProblem -> "import " + e.javaClass.packageName + "." + e.javaClass.simpleName }
            .toList()
            .joinToString("\n")

      strBu.append(
         """
         import org.junit.jupiter.api.Assertions
         import org.junit.jupiter.api.*
         import problems.PathSlave
         $importClasses
         import util.DLoader
         import util.IProblem
         
         """
            )
      strBu.append(
        """
         class JUnitTest {
         
         private val defaultLsg = Int.MIN_VALUE.toString()   
         
        """.trimIndent()
      )

      return strBu
   }

   private fun doMiddle(strBu: StringBuffer, allProblems: List<IProblem>): StringBuffer {
      var strBu = strBu
      for (tmpProb in allProblems) {
         val problemString = tmpProb.javaClass.simpleName
         strBu = generateProblemTestMethod(strBu, problemString)
      }

      return strBu
   }

   private fun generateProblemTestMethod(strBu: StringBuffer, problemName: String): StringBuffer {
      val varName = problemName.lowercase(Locale.getDefault())
      val testOrNot = if (!problemKinder.contains(problemName)) "\n	@Test\r\n" else "\n//	@Test\r\n"

      strBu.append(
         """$testOrNot	fun test$problemName() =
        DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
                .filterIsInstance<$problemName>()
                .firstOrNull()
                ?.let {$varName ->
                        Assertions.assertTrue(
                                  $varName.getSolution() != defaultLsg
                                        && $varName.solve() == $varName.getSolution()
                         )
                          }?: Assertions.fail()
         """
      )

      return strBu
   }

   private fun doEnd(strBu: StringBuffer): StringBuffer {
      strBu.append("}\r\n")
      return strBu
   }
}
