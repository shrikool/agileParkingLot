package shrikant.algorithms.dynamicprogramming;

import static shrikant.algorithms.dynamicprogramming.Catalan.getCatalanNumber;

public class CatalanNumber {
    // How many binary search trees are possible with n vertices ?
    // formula for the calculation is
    //C(n) = Sum<<from i to n>> { C<<i-1>1* C<<n-i>>
    // C(1) = C(0) * C(0)
    // C(2) = C(1) * C(1) + C(1) * C(0)
    // C(3) = C(2) * C(2) + C(2) * C(1) + C(2) * C(0)

    public static void main(String[] args) {
        System.out.println("Catalan number is " + getCatalanNumber(6));
    }
}

class Catalan {
    static int[] catalanNumber;
    static boolean onlyOnce = true;

    public static int getCatalanNumber(int number) {
        if (onlyOnce == true) {
            catalanNumber = new int[number + 1];
            catalanNumber[0] = 1;
            onlyOnce = false;
        }
        if (catalanNumber[number] != 0)
            return catalanNumber[number];
        for (int i = 1; i <= number; i++) {
            catalanNumber[number] += getCatalanNumber(i - 1) * getCatalanNumber(number - i);
        }
        return catalanNumber[number];
    }
}
