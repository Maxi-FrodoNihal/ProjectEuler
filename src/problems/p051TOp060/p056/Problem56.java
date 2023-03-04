package problems.p051TOp060.p056;

import util.IProblem;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem56 implements IProblem {

    @Override
    public String getSolution() {
        return "972";
    }

    @Override
    public String solve() {

        int noChangesBorder = 1;
        int noChanges = 0;
        long biggestQuerSumme = 0L;

        for(int i = 99 ; i > 0 && noChanges < noChangesBorder; --i){
            for(int j = 99 ; j > 0; --j){

                Long querSumme = querSumme(new BigInteger(String.valueOf(i)).pow(j));

                if(querSumme > biggestQuerSumme){
                    biggestQuerSumme = querSumme;
                    noChanges = 0;
                }else{
                    noChanges++;
                }
            }
        }

        return Long.toString(biggestQuerSumme);
    }

    private Long querSumme(BigInteger number){
        return Arrays.stream(number.toString().split("")).mapToLong(Long::valueOf).sum();
    }
}
