package shrikant.algorithms.dynamicprogramming;

import static java.lang.Integer.max;
import static shrikant.algorithms.dynamicprogramming.IntegerKnapsack.*;

public class IntegerKnapsackProblem {
    // DUPLICATE ITEMS ALLOWED
    // given n types of item where ith item type has an integer size si and value vi.
    // We need to fill a knapsack of total capacity C with items of maximum value.
    // We can add multiple items of the same type to the knapsack

    static int[][] elements = new int[][]{
//            new int[]{1, 1}, // size , value
            new int[]{2, 6}, // size , value
            new int[]{4, 10}
    };

    static int capacity = 4;

    public static void main(String[] args) {
        System.out.println("max value which can be achieved for capacity " + capacity + " is " + maxValue(capacity, elements));
    }
}

class IntegerKnapsack {
    // MaxValue(j) --> max value which we can achieve at capacity i
    // MaxValue(j) = Max{MaxValue(j-1), Sum<<i from 0 to n>> MaxValue(j - s(i)) + v[i]}

    static boolean onceOnly = true;
    static int[] maxTab;

    // accepts capacity and number of elements, second argument is not the part of the
    // mathematical equation but it is required because of programming constraints
    // This method returns the maximum value which we can achieve for a capacity
    // given with the elements
    // elements are given in the format of size and value (two dimensional array)
    public static int maxValue(int capacity, int[][] elements) {
        if (onceOnly == true) {
            maxTab = new int[capacity + 1];
            onceOnly = false;
        }

        if (capacity <= 0) {
            return 0;
        }

        if (maxTab[capacity] != 0)
            return maxTab[capacity];

        int sum = 0;
        for (int i = 0; i < elements.length && capacity >= elements[i][0]; i++) {
            sum = maxValue(capacity - elements[i][0], elements) + elements[i][1];
            maxTab[capacity] = max(maxTab[capacity], sum);
        }
        maxTab[capacity] = max(maxTab[capacity], maxValue(capacity - 1, elements));
        return maxTab[capacity];
    }
}
