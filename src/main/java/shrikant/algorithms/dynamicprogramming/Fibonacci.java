package shrikant.algorithms.dynamicprogramming;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import static shrikant.algorithms.dynamicprogramming.FibonacciHelper.*;

public class Fibonacci {
    // Sample of fibonacci
    // Index  0 1 2 3 4 5 6  7  9 10
    // Value  0 1 1 2 3 5 8 13 21 34
    // given n find the fibonacci term

    public static void main(String[] args) {
        System.out.println(iterativeFibonacci(9));
        System.out.println(recursiveFibonacci(9));
        initializedp();
        System.out.println(dpfib(10));
        System.out.println(dpfib(9));
    }

}

class FibonacciHelper {
    static int[] arrForFib = new int[20];

    public static int iterativeFibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int pre = 1;
        int preToPre = 0;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = pre + preToPre;
            preToPre = pre;
            pre = sum;
        }
        return sum;
    }

    public static int recursiveFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static void initializedp() {
        arrForFib = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    public static int dpfib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if(arrForFib[n] != -1){
            return arrForFib[n];
        }
        arrForFib[n] = dpfib(n-1) + dpfib(n-2);
        return arrForFib[n];
    }

}
