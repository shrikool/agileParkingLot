package shrikant.algorithms.dynamicprogramming;

import static java.lang.Integer.max;

public class ZeroOneKnapsackProblem {
    // DUPLICATION NOT ALLOWED
    // THOUGH THE NAME OF THE PROBLEM IS ZERO - ONE , but it works for the limited number of elements
    // because each element of same quantity can be break into this problem again
    // e.g two laptops of same weight can be considered as two laptops and in count 2 and two weights
    // How you solve IntegerKnapsackProblem when items are not duplicated
    // Copying below the statement from Integer knapsack problem
    // PROBLEM STATEMENT BEGINS
    // given n types of item where ith item type has an integer size si and value vi.
    // We need to fill a knapsack of total capacity C with items of maximum value.
    // We can add multiple items of the same type to the knapsack
    // PROBLEM STATEMENT ENDS

    public static int[][] getElements() {
        return new int[][]{
                new int[]{1, 1},
                new int[]{2, 11},
                new int[]{8, 10},
        };
    }

    public static void main(String[] args) {
        int[][] something = new int[1][1];
        something[0][0] = 1;

        int capacity = 8;
        int[][] elements = getElements();
        System.out.println(ZeroOneKnapsack.maxValue(elements.length - 1, capacity, elements));
    }
}


class ZeroOneKnapsack {
    // You have a knapsack of capacity C and then you have limited number of elements
    // with size s and value v and we have to maximise the the value of the elements
    // which we take to fill the knapsack.

    // Mathematical formula for the same would be
    // In the following formula, i is the i(th) element and j is the capacity (0 <= j <= C)
    // M[i, j] = Max[ M[i-1, j-s[i]] + v[i] <<if we select the ith element>> , M[i-1, j] << if we drop the ith element >> ]
    // and for both of the above cases the j > s[i]

    static boolean onceOnly = true;
    static int[][] maxValArr;

    public static int maxValue(int elementIndex, int capacity, int[][] elements) {
        if (elements == null || elements.length == 0)
            return 0;

        if (elementIndex < 0 || capacity <= 0)
            return 0;

        if (onceOnly) {
            maxValArr = new int[elements.length + 1][capacity + 1];
            onceOnly = false;
        }


        if (maxValArr[elementIndex][capacity] != 0)
            return maxValArr[elementIndex][capacity];

        for (int i = elementIndex; i >= 0; i--) {
            int valueWhenIisSelected = capacity >= elements[i][0] ? maxValue(i - 1, capacity - elements[i][0], elements) + elements[i][1] : 0;
            int valueWhenIisNotSelected = maxValue(i - 1, capacity, elements);
            maxValArr[i][capacity] = max(valueWhenIisNotSelected, valueWhenIisSelected);
            maxValArr[elementIndex][capacity] = max(maxValArr[elementIndex][capacity], maxValArr[i][capacity]);
        }

        return maxValArr[elementIndex][capacity];
    }

}