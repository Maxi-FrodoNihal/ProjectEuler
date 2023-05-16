package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import problems.*;
import problems.p001TOp010.p001.Problem1;
import problems.p001TOp010.p002.Problem2;
import problems.p001TOp010.p003.Problem3;
import problems.p001TOp010.p004.Problem4;
import problems.p001TOp010.p005.Problem5;
import problems.p001TOp010.p006.Problem6;
import problems.p001TOp010.p007.Problem7;
import problems.p001TOp010.p008.Problem8;
import problems.p001TOp010.p009.Problem9;
import problems.p001TOp010.p010.Problem10;
import problems.p011TOp020.p011.Problem11;
import problems.p011TOp020.p012.Problem12;
import problems.p011TOp020.p013.Problem13;
import problems.p011TOp020.p014.Problem14;
import problems.p011TOp020.p015.Problem15;
import problems.p011TOp020.p016.Problem16;
import problems.p011TOp020.p017.Problem17;
import problems.p011TOp020.p018.Problem18;
import problems.p011TOp020.p019.Problem19;
import problems.p011TOp020.p020.Problem20;
import problems.p021TOp030.p021.Problem21;
import problems.p021TOp030.p022.Problem22;
import problems.p021TOp030.p023.Problem23;
import problems.p021TOp030.p024.Problem24;
import problems.p021TOp030.p025.Problem25;
import problems.p021TOp030.p026.Problem26;
import problems.p021TOp030.p027.Problem27;
import problems.p021TOp030.p028.Problem28;
import problems.p021TOp030.p029.Problem29;
import problems.p021TOp030.p030.Problem30;
import problems.p031TOp040.p031.Problem31;
import problems.p031TOp040.p032.Problem32;
import problems.p031TOp040.p033.Problem33;
import problems.p031TOp040.p034.Problem34;
import problems.p031TOp040.p035.Problem35;
import problems.p031TOp040.p036.Problem36;
import problems.p031TOp040.p037.Problem37;
import problems.p031TOp040.p038.Problem38;
import problems.p031TOp040.p039.Problem39;
import problems.p031TOp040.p040.Problem40;
import problems.p041TOp050.p041.Problem41;
import problems.p041TOp050.p042.Problem42;
import problems.p041TOp050.p043.Problem43;
import problems.p041TOp050.p044.Problem44;
import problems.p041TOp050.p045.Problem45;
import problems.p041TOp050.p046.Problem46;
import problems.p041TOp050.p047.Problem47;
import problems.p041TOp050.p048.Problem48;
import problems.p041TOp050.p049.Problem49;
import problems.p041TOp050.p050.Problem50;
import problems.p051TOp060.p051.Problem51;
import problems.p051TOp060.p052.Problem52;
import problems.p051TOp060.p053.Problem53;
import problems.p051TOp060.p055.Problem55;
import problems.p051TOp060.p056.Problem56;
import problems.p051TOp060.p057.Problem57;
import problems.p051TOp060.p058.Problem58;
import util.DLoader;
import util.IProblem;
public class JUnitTest {

    private String defaultLsg = String.valueOf(Integer.MIN_VALUE);
    @Test
    public void testProblem1() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem1 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem1).findFirst()
                .get();

        assertTrue(problem1.getSolution().equals(defaultLsg) == false && problem1.solve().equals(problem1.getSolution()));
    }
    @Test
    public void testProblem2() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem2 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem2).findFirst()
                .get();

        assertTrue(problem2.getSolution().equals(defaultLsg) == false && problem2.solve().equals(problem2.getSolution()));
    }
    @Test
    public void testProblem3() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem3 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem3).findFirst()
                .get();

        assertTrue(problem3.getSolution().equals(defaultLsg) == false && problem3.solve().equals(problem3.getSolution()));
    }
    @Test
    public void testProblem4() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem4 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem4).findFirst()
                .get();

        assertTrue(problem4.getSolution().equals(defaultLsg) == false && problem4.solve().equals(problem4.getSolution()));
    }
    @Test
    public void testProblem5() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem5 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem5).findFirst()
                .get();

        assertTrue(problem5.getSolution().equals(defaultLsg) == false && problem5.solve().equals(problem5.getSolution()));
    }
    @Test
    public void testProblem6() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem6 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem6).findFirst()
                .get();

        assertTrue(problem6.getSolution().equals(defaultLsg) == false && problem6.solve().equals(problem6.getSolution()));
    }
    @Test
    public void testProblem7() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem7 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem7).findFirst()
                .get();

        assertTrue(problem7.getSolution().equals(defaultLsg) == false && problem7.solve().equals(problem7.getSolution()));
    }
    @Test
    public void testProblem8() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem8 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem8).findFirst()
                .get();

        assertTrue(problem8.getSolution().equals(defaultLsg) == false && problem8.solve().equals(problem8.getSolution()));
    }
    @Test
    public void testProblem9() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem9 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem9).findFirst()
                .get();

        assertTrue(problem9.getSolution().equals(defaultLsg) == false && problem9.solve().equals(problem9.getSolution()));
    }
    @Test
    public void testProblem10() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem10 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem10).findFirst()
                .get();

        assertTrue(problem10.getSolution().equals(defaultLsg) == false && problem10.solve().equals(problem10.getSolution()));
    }
    @Test
    public void testProblem11() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem11 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem11).findFirst()
                .get();

        assertTrue(problem11.getSolution().equals(defaultLsg) == false && problem11.solve().equals(problem11.getSolution()));
    }
    @Test
    public void testProblem12() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem12 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem12).findFirst()
                .get();

        assertTrue(problem12.getSolution().equals(defaultLsg) == false && problem12.solve().equals(problem12.getSolution()));
    }
    @Test
    public void testProblem13() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem13 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem13).findFirst()
                .get();

        assertTrue(problem13.getSolution().equals(defaultLsg) == false && problem13.solve().equals(problem13.getSolution()));
    }
    @Test
    public void testProblem14() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem14 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem14).findFirst()
                .get();

        assertTrue(problem14.getSolution().equals(defaultLsg) == false && problem14.solve().equals(problem14.getSolution()));
    }
    @Test
    public void testProblem15() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem15 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem15).findFirst()
                .get();

        assertTrue(problem15.getSolution().equals(defaultLsg) == false && problem15.solve().equals(problem15.getSolution()));
    }
    @Test
    public void testProblem16() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem16 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem16).findFirst()
                .get();

        assertTrue(problem16.getSolution().equals(defaultLsg) == false && problem16.solve().equals(problem16.getSolution()));
    }
    @Test
    public void testProblem17() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem17 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem17).findFirst()
                .get();

        assertTrue(problem17.getSolution().equals(defaultLsg) == false && problem17.solve().equals(problem17.getSolution()));
    }
    //	@Test
    public void testProblem18() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem18 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem18).findFirst()
                .get();

        assertTrue(problem18.getSolution().equals(defaultLsg) == false && problem18.solve().equals(problem18.getSolution()));
    }
    @Test
    public void testProblem19() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem19 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem19).findFirst()
                .get();

        assertTrue(problem19.getSolution().equals(defaultLsg) == false && problem19.solve().equals(problem19.getSolution()));
    }
    @Test
    public void testProblem20() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem20 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem20).findFirst()
                .get();

        assertTrue(problem20.getSolution().equals(defaultLsg) == false && problem20.solve().equals(problem20.getSolution()));
    }
    @Test
    public void testProblem21() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem21 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem21).findFirst()
                .get();

        assertTrue(problem21.getSolution().equals(defaultLsg) == false && problem21.solve().equals(problem21.getSolution()));
    }
    @Test
    public void testProblem22() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem22 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem22).findFirst()
                .get();

        assertTrue(problem22.getSolution().equals(defaultLsg) == false && problem22.solve().equals(problem22.getSolution()));
    }
    @Test
    public void testProblem23() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem23 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem23).findFirst()
                .get();

        assertTrue(problem23.getSolution().equals(defaultLsg) == false && problem23.solve().equals(problem23.getSolution()));
    }
    @Test
    public void testProblem24() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem24 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem24).findFirst()
                .get();

        assertTrue(problem24.getSolution().equals(defaultLsg) == false && problem24.solve().equals(problem24.getSolution()));
    }
    @Test
    public void testProblem25() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem25 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem25).findFirst()
                .get();

        assertTrue(problem25.getSolution().equals(defaultLsg) == false && problem25.solve().equals(problem25.getSolution()));
    }
    @Test
    public void testProblem26() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem26 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem26).findFirst()
                .get();

        assertTrue(problem26.getSolution().equals(defaultLsg) == false && problem26.solve().equals(problem26.getSolution()));
    }
    @Test
    public void testProblem27() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem27 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem27).findFirst()
                .get();

        assertTrue(problem27.getSolution().equals(defaultLsg) == false && problem27.solve().equals(problem27.getSolution()));
    }
    @Test
    public void testProblem28() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem28 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem28).findFirst()
                .get();

        assertTrue(problem28.getSolution().equals(defaultLsg) == false && problem28.solve().equals(problem28.getSolution()));
    }
    @Test
    public void testProblem29() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem29 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem29).findFirst()
                .get();

        assertTrue(problem29.getSolution().equals(defaultLsg) == false && problem29.solve().equals(problem29.getSolution()));
    }
    @Test
    public void testProblem30() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem30 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem30).findFirst()
                .get();

        assertTrue(problem30.getSolution().equals(defaultLsg) == false && problem30.solve().equals(problem30.getSolution()));
    }
    @Test
    public void testProblem31() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem31 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem31).findFirst()
                .get();

        assertTrue(problem31.getSolution().equals(defaultLsg) == false && problem31.solve().equals(problem31.getSolution()));
    }
    @Test
    public void testProblem32() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem32 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem32).findFirst()
                .get();

        assertTrue(problem32.getSolution().equals(defaultLsg) == false && problem32.solve().equals(problem32.getSolution()));
    }
    @Test
    public void testProblem33() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem33 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem33).findFirst()
                .get();

        assertTrue(problem33.getSolution().equals(defaultLsg) == false && problem33.solve().equals(problem33.getSolution()));
    }
    @Test
    public void testProblem34() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem34 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem34).findFirst()
                .get();

        assertTrue(problem34.getSolution().equals(defaultLsg) == false && problem34.solve().equals(problem34.getSolution()));
    }
    @Test
    public void testProblem35() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem35 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem35).findFirst()
                .get();

        assertTrue(problem35.getSolution().equals(defaultLsg) == false && problem35.solve().equals(problem35.getSolution()));
    }
    @Test
    public void testProblem36() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem36 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem36).findFirst()
                .get();

        assertTrue(problem36.getSolution().equals(defaultLsg) == false && problem36.solve().equals(problem36.getSolution()));
    }
    @Test
    public void testProblem37() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem37 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem37).findFirst()
                .get();

        assertTrue(problem37.getSolution().equals(defaultLsg) == false && problem37.solve().equals(problem37.getSolution()));
    }
    @Test
    public void testProblem38() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem38 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem38).findFirst()
                .get();

        assertTrue(problem38.getSolution().equals(defaultLsg) == false && problem38.solve().equals(problem38.getSolution()));
    }
    @Test
    public void testProblem39() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem39 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem39).findFirst()
                .get();

        assertTrue(problem39.getSolution().equals(defaultLsg) == false && problem39.solve().equals(problem39.getSolution()));
    }
    @Test
    public void testProblem40() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem40 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem40).findFirst()
                .get();

        assertTrue(problem40.getSolution().equals(defaultLsg) == false && problem40.solve().equals(problem40.getSolution()));
    }
    @Test
    public void testProblem41() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem41 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem41).findFirst()
                .get();

        assertTrue(problem41.getSolution().equals(defaultLsg) == false && problem41.solve().equals(problem41.getSolution()));
    }
    @Test
    public void testProblem42() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem42 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem42).findFirst()
                .get();

        assertTrue(problem42.getSolution().equals(defaultLsg) == false && problem42.solve().equals(problem42.getSolution()));
    }
    @Test
    public void testProblem43() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem43 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem43).findFirst()
                .get();

        assertTrue(problem43.getSolution().equals(defaultLsg) == false && problem43.solve().equals(problem43.getSolution()));
    }
    @Test
    public void testProblem44() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem44 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem44).findFirst()
                .get();

        assertTrue(problem44.getSolution().equals(defaultLsg) == false && problem44.solve().equals(problem44.getSolution()));
    }
    @Test
    public void testProblem45() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem45 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem45).findFirst()
                .get();

        assertTrue(problem45.getSolution().equals(defaultLsg) == false && problem45.solve().equals(problem45.getSolution()));
    }
    @Test
    public void testProblem46() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem46 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem46).findFirst()
                .get();

        assertTrue(problem46.getSolution().equals(defaultLsg) == false && problem46.solve().equals(problem46.getSolution()));
    }
    @Test
    public void testProblem47() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem47 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem47).findFirst()
                .get();

        assertTrue(problem47.getSolution().equals(defaultLsg) == false && problem47.solve().equals(problem47.getSolution()));
    }
    @Test
    public void testProblem48() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem48 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem48).findFirst()
                .get();

        assertTrue(problem48.getSolution().equals(defaultLsg) == false && problem48.solve().equals(problem48.getSolution()));
    }
    @Test
    public void testProblem49() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem49 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem49).findFirst()
                .get();

        assertTrue(problem49.getSolution().equals(defaultLsg) == false && problem49.solve().equals(problem49.getSolution()));
    }
    @Test
    public void testProblem50() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem50 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem50).findFirst()
                .get();

        assertTrue(problem50.getSolution().equals(defaultLsg) == false && problem50.solve().equals(problem50.getSolution()));
    }
    @Test
    public void testProblem51() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem51 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem51).findFirst()
                .get();

        assertTrue(problem51.getSolution().equals(defaultLsg) == false && problem51.solve().equals(problem51.getSolution()));
    }
    @Test
    public void testProblem52() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem52 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem52).findFirst()
                .get();

        assertTrue(problem52.getSolution().equals(defaultLsg) == false && problem52.solve().equals(problem52.getSolution()));
    }
    @Test
    public void testProblem53() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem53 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem53).findFirst()
                .get();

        assertTrue(problem53.getSolution().equals(defaultLsg) == false && problem53.solve().equals(problem53.getSolution()));
    }
    @Test
    public void testProblem55() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem55 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem55).findFirst()
                .get();

        assertTrue(problem55.getSolution().equals(defaultLsg) == false && problem55.solve().equals(problem55.getSolution()));
    }
    @Test
    public void testProblem56() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem56 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem56).findFirst()
                .get();

        assertTrue(problem56.getSolution().equals(defaultLsg) == false && problem56.solve().equals(problem56.getSolution()));
    }
    @Test
    public void testProblem57() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem57 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem57).findFirst()
                .get();

        assertTrue(problem57.getSolution().equals(defaultLsg) == false && problem57.solve().equals(problem57.getSolution()));
    }
    @Test
    public void testProblem58() {

        List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

        IProblem problem58 = allProblems.stream().filter(tmpProbelem -> tmpProbelem instanceof Problem58).findFirst()
                .get();

        assertTrue(problem58.getSolution().equals(defaultLsg) == false && problem58.solve().equals(problem58.getSolution()));
    }}
