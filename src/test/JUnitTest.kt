
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.*
import problems.PathSlave
import problems.calendar.y23.d01.Door23_01_Level_1
import problems.calendar.y23.d01.Door23_01_Level_2
import problems.calendar.y23.d02.Door23_02_Level_1
import problems.calendar.y23.d02.Door23_02_Level_2
import problems.calendar.y23.d03.Door23_03_Level_1
import problems.calendar.y23.d03.Door23_03_Level_2
import problems.calendar.y23.d04.Door23_04_Level_1
import problems.p001TOp010.p001.Problem1
import problems.p001TOp010.p002.Problem2
import problems.p001TOp010.p003.Problem3
import problems.p001TOp010.p004.Problem4
import problems.p001TOp010.p005.Problem5
import problems.p001TOp010.p006.Problem6
import problems.p001TOp010.p007.Problem7
import problems.p001TOp010.p008.Problem8
import problems.p001TOp010.p009.Problem9
import problems.p001TOp010.p010.Problem10
import problems.p011TOp020.p011.Problem11
import problems.p011TOp020.p012.Problem12
import problems.p011TOp020.p013.Problem13
import problems.p011TOp020.p014.Problem14
import problems.p011TOp020.p015.Problem15
import problems.p011TOp020.p016.Problem16
import problems.p011TOp020.p017.Problem17
import problems.p011TOp020.p018.Problem18
import problems.p011TOp020.p019.Problem19
import problems.p011TOp020.p020.Problem20
import problems.p021TOp030.p021.Problem21
import problems.p021TOp030.p022.Problem22
import problems.p021TOp030.p023.Problem23
import problems.p021TOp030.p024.Problem24
import problems.p021TOp030.p025.Problem25
import problems.p021TOp030.p026.Problem26
import problems.p021TOp030.p027.Problem27
import problems.p021TOp030.p028.Problem28
import problems.p021TOp030.p029.Problem29
import problems.p021TOp030.p030.Problem30
import problems.p031TOp040.p031.Problem31
import problems.p031TOp040.p032.Problem32
import problems.p031TOp040.p033.Problem33
import problems.p031TOp040.p034.Problem34
import problems.p031TOp040.p035.Problem35
import problems.p031TOp040.p036.Problem36
import problems.p031TOp040.p037.Problem37
import problems.p031TOp040.p038.Problem38
import problems.p031TOp040.p039.Problem39
import problems.p031TOp040.p040.Problem40
import problems.p041TOp050.p041.Problem41
import problems.p041TOp050.p042.Problem42
import problems.p041TOp050.p043.Problem43
import problems.p041TOp050.p044.Problem44
import problems.p041TOp050.p045.Problem45
import problems.p041TOp050.p046.Problem46
import problems.p041TOp050.p047.Problem47
import problems.p041TOp050.p048.Problem48
import problems.p041TOp050.p049.Problem49
import problems.p041TOp050.p050.Problem50
import problems.p051TOp060.p051.Problem51
import problems.p051TOp060.p052.Problem52
import problems.p051TOp060.p053.Problem53
import problems.p051TOp060.p055.Problem55
import problems.p051TOp060.p056.Problem56
import problems.p051TOp060.p057.Problem57
import problems.p051TOp060.p058.Problem58
import problems.p051TOp060.p059.Problem59
import problems.p051TOp060.p060.Problem60
import problems.p061TOp070.p061.Problem61
import problems.p061TOp070.p062.Problem62
import problems.p061TOp070.p063.Problem63
import util.DLoader
import util.IProblem

class JUnitTest {

   private val defaultLsg = Int.MIN_VALUE.toString()

   @Test
   fun testDoor23_01_Level_1() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Door23_01_Level_1>()
         .firstOrNull()
         ?.let {door23_01_level_1 ->
            Assertions.assertTrue(
               door23_01_level_1.getSolution() != defaultLsg
                       && door23_01_level_1.solve() == door23_01_level_1.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testDoor23_01_Level_2() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Door23_01_Level_2>()
         .firstOrNull()
         ?.let {door23_01_level_2 ->
            Assertions.assertTrue(
               door23_01_level_2.getSolution() != defaultLsg
                       && door23_01_level_2.solve() == door23_01_level_2.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testDoor23_02_Level_1() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Door23_02_Level_1>()
         .firstOrNull()
         ?.let {door23_02_level_1 ->
            Assertions.assertTrue(
               door23_02_level_1.getSolution() != defaultLsg
                       && door23_02_level_1.solve() == door23_02_level_1.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testDoor23_02_Level_2() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Door23_02_Level_2>()
         .firstOrNull()
         ?.let {door23_02_level_2 ->
            Assertions.assertTrue(
               door23_02_level_2.getSolution() != defaultLsg
                       && door23_02_level_2.solve() == door23_02_level_2.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testDoor23_03_Level_1() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Door23_03_Level_1>()
         .firstOrNull()
         ?.let {door23_03_level_1 ->
            Assertions.assertTrue(
               door23_03_level_1.getSolution() != defaultLsg
                       && door23_03_level_1.solve() == door23_03_level_1.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testDoor23_03_Level_2() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Door23_03_Level_2>()
         .firstOrNull()
         ?.let {door23_03_level_2 ->
            Assertions.assertTrue(
               door23_03_level_2.getSolution() != defaultLsg
                       && door23_03_level_2.solve() == door23_03_level_2.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testDoor23_04_Level_1() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Door23_04_Level_1>()
         .firstOrNull()
         ?.let {door23_04_level_1 ->
            Assertions.assertTrue(
               door23_04_level_1.getSolution() != defaultLsg
                       && door23_04_level_1.solve() == door23_04_level_1.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem1() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem1>()
         .firstOrNull()
         ?.let {problem1 ->
            Assertions.assertTrue(
               problem1.getSolution() != defaultLsg
                       && problem1.solve() == problem1.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem2() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem2>()
         .firstOrNull()
         ?.let {problem2 ->
            Assertions.assertTrue(
               problem2.getSolution() != defaultLsg
                       && problem2.solve() == problem2.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem3() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem3>()
         .firstOrNull()
         ?.let {problem3 ->
            Assertions.assertTrue(
               problem3.getSolution() != defaultLsg
                       && problem3.solve() == problem3.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem4() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem4>()
         .firstOrNull()
         ?.let {problem4 ->
            Assertions.assertTrue(
               problem4.getSolution() != defaultLsg
                       && problem4.solve() == problem4.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem5() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem5>()
         .firstOrNull()
         ?.let {problem5 ->
            Assertions.assertTrue(
               problem5.getSolution() != defaultLsg
                       && problem5.solve() == problem5.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem6() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem6>()
         .firstOrNull()
         ?.let {problem6 ->
            Assertions.assertTrue(
               problem6.getSolution() != defaultLsg
                       && problem6.solve() == problem6.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem7() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem7>()
         .firstOrNull()
         ?.let {problem7 ->
            Assertions.assertTrue(
               problem7.getSolution() != defaultLsg
                       && problem7.solve() == problem7.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem8() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem8>()
         .firstOrNull()
         ?.let {problem8 ->
            Assertions.assertTrue(
               problem8.getSolution() != defaultLsg
                       && problem8.solve() == problem8.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem9() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem9>()
         .firstOrNull()
         ?.let {problem9 ->
            Assertions.assertTrue(
               problem9.getSolution() != defaultLsg
                       && problem9.solve() == problem9.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem10() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem10>()
         .firstOrNull()
         ?.let {problem10 ->
            Assertions.assertTrue(
               problem10.getSolution() != defaultLsg
                       && problem10.solve() == problem10.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem11() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem11>()
         .firstOrNull()
         ?.let {problem11 ->
            Assertions.assertTrue(
               problem11.getSolution() != defaultLsg
                       && problem11.solve() == problem11.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem12() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem12>()
         .firstOrNull()
         ?.let {problem12 ->
            Assertions.assertTrue(
               problem12.getSolution() != defaultLsg
                       && problem12.solve() == problem12.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem13() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem13>()
         .firstOrNull()
         ?.let {problem13 ->
            Assertions.assertTrue(
               problem13.getSolution() != defaultLsg
                       && problem13.solve() == problem13.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem14() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem14>()
         .firstOrNull()
         ?.let {problem14 ->
            Assertions.assertTrue(
               problem14.getSolution() != defaultLsg
                       && problem14.solve() == problem14.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem15() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem15>()
         .firstOrNull()
         ?.let {problem15 ->
            Assertions.assertTrue(
               problem15.getSolution() != defaultLsg
                       && problem15.solve() == problem15.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem16() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem16>()
         .firstOrNull()
         ?.let {problem16 ->
            Assertions.assertTrue(
               problem16.getSolution() != defaultLsg
                       && problem16.solve() == problem16.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem17() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem17>()
         .firstOrNull()
         ?.let {problem17 ->
            Assertions.assertTrue(
               problem17.getSolution() != defaultLsg
                       && problem17.solve() == problem17.getSolution()
            )
         }?: Assertions.fail()

   //	@Test
   fun testProblem18() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem18>()
         .firstOrNull()
         ?.let {problem18 ->
            Assertions.assertTrue(
               problem18.getSolution() != defaultLsg
                       && problem18.solve() == problem18.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem19() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem19>()
         .firstOrNull()
         ?.let {problem19 ->
            Assertions.assertTrue(
               problem19.getSolution() != defaultLsg
                       && problem19.solve() == problem19.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem20() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem20>()
         .firstOrNull()
         ?.let {problem20 ->
            Assertions.assertTrue(
               problem20.getSolution() != defaultLsg
                       && problem20.solve() == problem20.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem21() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem21>()
         .firstOrNull()
         ?.let {problem21 ->
            Assertions.assertTrue(
               problem21.getSolution() != defaultLsg
                       && problem21.solve() == problem21.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem22() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem22>()
         .firstOrNull()
         ?.let {problem22 ->
            Assertions.assertTrue(
               problem22.getSolution() != defaultLsg
                       && problem22.solve() == problem22.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem23() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem23>()
         .firstOrNull()
         ?.let {problem23 ->
            Assertions.assertTrue(
               problem23.getSolution() != defaultLsg
                       && problem23.solve() == problem23.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem24() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem24>()
         .firstOrNull()
         ?.let {problem24 ->
            Assertions.assertTrue(
               problem24.getSolution() != defaultLsg
                       && problem24.solve() == problem24.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem25() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem25>()
         .firstOrNull()
         ?.let {problem25 ->
            Assertions.assertTrue(
               problem25.getSolution() != defaultLsg
                       && problem25.solve() == problem25.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem26() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem26>()
         .firstOrNull()
         ?.let {problem26 ->
            Assertions.assertTrue(
               problem26.getSolution() != defaultLsg
                       && problem26.solve() == problem26.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem27() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem27>()
         .firstOrNull()
         ?.let {problem27 ->
            Assertions.assertTrue(
               problem27.getSolution() != defaultLsg
                       && problem27.solve() == problem27.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem28() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem28>()
         .firstOrNull()
         ?.let {problem28 ->
            Assertions.assertTrue(
               problem28.getSolution() != defaultLsg
                       && problem28.solve() == problem28.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem29() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem29>()
         .firstOrNull()
         ?.let {problem29 ->
            Assertions.assertTrue(
               problem29.getSolution() != defaultLsg
                       && problem29.solve() == problem29.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem30() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem30>()
         .firstOrNull()
         ?.let {problem30 ->
            Assertions.assertTrue(
               problem30.getSolution() != defaultLsg
                       && problem30.solve() == problem30.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem31() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem31>()
         .firstOrNull()
         ?.let {problem31 ->
            Assertions.assertTrue(
               problem31.getSolution() != defaultLsg
                       && problem31.solve() == problem31.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem32() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem32>()
         .firstOrNull()
         ?.let {problem32 ->
            Assertions.assertTrue(
               problem32.getSolution() != defaultLsg
                       && problem32.solve() == problem32.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem33() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem33>()
         .firstOrNull()
         ?.let {problem33 ->
            Assertions.assertTrue(
               problem33.getSolution() != defaultLsg
                       && problem33.solve() == problem33.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem34() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem34>()
         .firstOrNull()
         ?.let {problem34 ->
            Assertions.assertTrue(
               problem34.getSolution() != defaultLsg
                       && problem34.solve() == problem34.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem35() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem35>()
         .firstOrNull()
         ?.let {problem35 ->
            Assertions.assertTrue(
               problem35.getSolution() != defaultLsg
                       && problem35.solve() == problem35.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem36() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem36>()
         .firstOrNull()
         ?.let {problem36 ->
            Assertions.assertTrue(
               problem36.getSolution() != defaultLsg
                       && problem36.solve() == problem36.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem37() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem37>()
         .firstOrNull()
         ?.let {problem37 ->
            Assertions.assertTrue(
               problem37.getSolution() != defaultLsg
                       && problem37.solve() == problem37.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem38() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem38>()
         .firstOrNull()
         ?.let {problem38 ->
            Assertions.assertTrue(
               problem38.getSolution() != defaultLsg
                       && problem38.solve() == problem38.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem39() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem39>()
         .firstOrNull()
         ?.let {problem39 ->
            Assertions.assertTrue(
               problem39.getSolution() != defaultLsg
                       && problem39.solve() == problem39.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem40() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem40>()
         .firstOrNull()
         ?.let {problem40 ->
            Assertions.assertTrue(
               problem40.getSolution() != defaultLsg
                       && problem40.solve() == problem40.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem41() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem41>()
         .firstOrNull()
         ?.let {problem41 ->
            Assertions.assertTrue(
               problem41.getSolution() != defaultLsg
                       && problem41.solve() == problem41.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem42() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem42>()
         .firstOrNull()
         ?.let {problem42 ->
            Assertions.assertTrue(
               problem42.getSolution() != defaultLsg
                       && problem42.solve() == problem42.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem43() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem43>()
         .firstOrNull()
         ?.let {problem43 ->
            Assertions.assertTrue(
               problem43.getSolution() != defaultLsg
                       && problem43.solve() == problem43.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem44() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem44>()
         .firstOrNull()
         ?.let {problem44 ->
            Assertions.assertTrue(
               problem44.getSolution() != defaultLsg
                       && problem44.solve() == problem44.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem45() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem45>()
         .firstOrNull()
         ?.let {problem45 ->
            Assertions.assertTrue(
               problem45.getSolution() != defaultLsg
                       && problem45.solve() == problem45.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem46() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem46>()
         .firstOrNull()
         ?.let {problem46 ->
            Assertions.assertTrue(
               problem46.getSolution() != defaultLsg
                       && problem46.solve() == problem46.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem47() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem47>()
         .firstOrNull()
         ?.let {problem47 ->
            Assertions.assertTrue(
               problem47.getSolution() != defaultLsg
                       && problem47.solve() == problem47.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem48() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem48>()
         .firstOrNull()
         ?.let {problem48 ->
            Assertions.assertTrue(
               problem48.getSolution() != defaultLsg
                       && problem48.solve() == problem48.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem49() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem49>()
         .firstOrNull()
         ?.let {problem49 ->
            Assertions.assertTrue(
               problem49.getSolution() != defaultLsg
                       && problem49.solve() == problem49.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem50() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem50>()
         .firstOrNull()
         ?.let {problem50 ->
            Assertions.assertTrue(
               problem50.getSolution() != defaultLsg
                       && problem50.solve() == problem50.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem51() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem51>()
         .firstOrNull()
         ?.let {problem51 ->
            Assertions.assertTrue(
               problem51.getSolution() != defaultLsg
                       && problem51.solve() == problem51.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem52() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem52>()
         .firstOrNull()
         ?.let {problem52 ->
            Assertions.assertTrue(
               problem52.getSolution() != defaultLsg
                       && problem52.solve() == problem52.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem53() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem53>()
         .firstOrNull()
         ?.let {problem53 ->
            Assertions.assertTrue(
               problem53.getSolution() != defaultLsg
                       && problem53.solve() == problem53.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem55() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem55>()
         .firstOrNull()
         ?.let {problem55 ->
            Assertions.assertTrue(
               problem55.getSolution() != defaultLsg
                       && problem55.solve() == problem55.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem56() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem56>()
         .firstOrNull()
         ?.let {problem56 ->
            Assertions.assertTrue(
               problem56.getSolution() != defaultLsg
                       && problem56.solve() == problem56.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem57() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem57>()
         .firstOrNull()
         ?.let {problem57 ->
            Assertions.assertTrue(
               problem57.getSolution() != defaultLsg
                       && problem57.solve() == problem57.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem58() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem58>()
         .firstOrNull()
         ?.let {problem58 ->
            Assertions.assertTrue(
               problem58.getSolution() != defaultLsg
                       && problem58.solve() == problem58.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem59() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem59>()
         .firstOrNull()
         ?.let {problem59 ->
            Assertions.assertTrue(
               problem59.getSolution() != defaultLsg
                       && problem59.solve() == problem59.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem60() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem60>()
         .firstOrNull()
         ?.let {problem60 ->
            Assertions.assertTrue(
               problem60.getSolution() != defaultLsg
                       && problem60.solve() == problem60.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem61() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem61>()
         .firstOrNull()
         ?.let {problem61 ->
            Assertions.assertTrue(
               problem61.getSolution() != defaultLsg
                       && problem61.solve() == problem61.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem62() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem62>()
         .firstOrNull()
         ?.let {problem62 ->
            Assertions.assertTrue(
               problem62.getSolution() != defaultLsg
                       && problem62.solve() == problem62.getSolution()
            )
         }?: Assertions.fail()

   @Test
   fun testProblem63() =
      DLoader.loadInterfaceObjectsFromT(PathSlave::class.java, IProblem::class.java)
         .filterIsInstance<Problem63>()
         .firstOrNull()
         ?.let {problem63 ->
            Assertions.assertTrue(
               problem63.getSolution() != defaultLsg
                       && problem63.solve() == problem63.getSolution()
            )
         }?: Assertions.fail()
}
