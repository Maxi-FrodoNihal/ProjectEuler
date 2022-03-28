package problems.p041TOp050.p043;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PandigiCallable implements Callable<List<String>> {

	private long start; 
	private long end;
	
	public PandigiCallable(long start, long end) {
		this.start = start;
		this.end = end;
	}


	@Override
	public List<String> call() throws Exception {
		
		List<String> pandigiNumbers = new ArrayList<String>();
		
		for(long i = start ; i < end ; ++i) {
			
			String strI = String.valueOf(i);
			
			if(strI.length() == 9) {
				strI = "0"+strI;
			}
			
			if(contains0to9(strI)) {
				pandigiNumbers.add(strI);
			}
		}
		
		return pandigiNumbers;
	}

	private boolean contains0to9(String number) {

		boolean containsAll = true;

		for (int i = 0; i <= 9 && containsAll; ++i) {
			containsAll &= number.contains(String.valueOf(i));
		}

		return containsAll;
	}
	
}
