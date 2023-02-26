package problems.p051TOp060.p055;

import util.IProblem;

import java.math.BigInteger;

public class Problem55 implements IProblem {

    private final StringBuilder strBuild = new StringBuilder();

    @Override
    public String getSolution() {
        return "249";
    }

    @Override
    public String solve() {

        int lNumberCounter = 0;

        for(int i = 1 ; i < 10000 ; ++i){

            BigInteger solution = new BigInteger(String.valueOf(i));
            int counter = 0;

            do{

                solution = solution.add(revert(solution));
                ++counter;

            }while(!isPalindrome(solution) && counter < 50);

            if(counter >= 50){
                ++lNumberCounter;
            }
        }

        return String.valueOf(lNumberCounter);
    }

    private BigInteger revert(BigInteger number){

        strBuild.append(number);
        BigInteger revertNumber = new BigInteger(strBuild.reverse().toString());
        strBuild.setLength(0);

        return revertNumber;
    }

    private boolean isPalindrome(BigInteger number){

        strBuild.append(number);
        boolean isPalindrome = strBuild.reverse().toString().equals(number.toString());
        strBuild.setLength(0);

        return isPalindrome;
    }
}
