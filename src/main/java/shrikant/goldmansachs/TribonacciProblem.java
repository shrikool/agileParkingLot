package shrikant.goldmansachs;

import static shrikant.goldmansachs.Tribonacci.*;

public class TribonacciProblem {
    public static void main(String[] args) {
        int n = 9;
        System.out.println("Tribonacci series is for " + n + " is " + getTribonacciTerm(n));
    }
}



class Tribonacci{
    // 0 1 1 2 4 7 13 24 44 81
    // Sum of previous three terms


    public static int getTribonacciTerm(int num){
        if (num == 0)
            return 0;
        if (num == 1 || num == 2)
            return 1;

        int preTopreTopre = 0;
        int preTopre = 1;
        int pre = 1;

        int sum = 0;
        for (int i = 3 ; i <= num ; i++){
            sum = preTopreTopre + preTopre + pre;
            preTopreTopre = preTopre;
            preTopre = pre;
            pre = sum;
        }

        return sum;
    }
}
