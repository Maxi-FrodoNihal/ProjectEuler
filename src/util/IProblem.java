package util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;

public interface IProblem {

	String solve();

	default int getIterations() {
		return 1;
	}

	default String getSolution() {
		return String.valueOf(Integer.MIN_VALUE);
	}

	default String readLocalFile(String filename){
		InputStream resourceAsStream = this.getClass().getResourceAsStream(filename);

		if(resourceAsStream == null){
			return "";
		}

		return String.join("\n", IOUtils.readLines(resourceAsStream, "UTF-8"));
	}
}
