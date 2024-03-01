package test;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import problems.PathSlave;
import util.DLoader;
import util.IProblem;

public class DTestWriter {

	private String[] exept = { "Problem18" };
	private Set<String> problemKinder = new HashSet<String>(Arrays.asList(exept));

	public static void main(String[] args) {
		new DTestWriter().generateTestFile();
		System.out.println("Ist im Clipboard. :)");
	}

	public void generateTestFile() {

		StringBuffer strBu = new StringBuffer();

		strBu = doTop(strBu);
		strBu = doMiddle(strBu);
		strBu = doEnd(strBu);

		StringSelection selection = new StringSelection(strBu.toString());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
	}

	private StringBuffer doTop(StringBuffer strBu) {

		strBu.append("package test;\r\n" + "\r\n" + "import static org.junit.Assert.assertFalse;\r\n"
				+ "import static org.junit.Assert.assertTrue;\r\n" + "\r\n" + "import java.util.List;\r\n" + "\r\n"
				+ "import org.junit.jupiter.api.Test;\r\n" + "\r\n" + "import problems.*;\r\n"
				+ "import util.DLoader;\r\n" + "import util.IProblem;");
		strBu.append("\r\n" + "public class JUnitTest {\r\n" + "\r\n"
				+ "	private String defaultLsg = String.valueOf(Integer.MIN_VALUE);");

		return strBu;
	}

	private StringBuffer doMiddle(StringBuffer strBu) {

		List<IProblem> allProblems = DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class);

		for (IProblem tmpProb : allProblems) {
			String problemString = tmpProb.getClass().getSimpleName();
			strBu = generateProblemTestMethod(strBu, problemString);
		}

		return strBu;
	}

	private StringBuffer generateProblemTestMethod(StringBuffer strBu, String problemName) {

		String varName = problemName.toLowerCase();
		String testOrNot = problemKinder.contains(problemName) == false ? "\n	@Test\r\n" : "\n//	@Test\r\n";

		strBu.append(""+testOrNot+
				"	public void test"+problemName+"() {\n"+
				"        DLoader.loadInterfaceObjectsFromT(PathSlave.class, IProblem.class)\n" +
				"                .stream()\n" +
				"                .filter("+problemName+".class::isInstance)\n" +
				"                .findFirst()\n" +
				"                .ifPresentOrElse("+varName+" ->\n" +
				"                        Assertions.assertTrue(\n" +
				"                                  !"+varName+".getSolution().equals(defaultLsg)\n" +
				"                                        && "+varName+".solve().equals("+varName+".getSolution())),\n" +
				"                          Assertions::fail);\n"+
				"	}");



		return strBu;
	}

	private StringBuffer doEnd(StringBuffer strBu) {

		strBu.append("}\r\n" + "");

		return strBu;
	}
}
