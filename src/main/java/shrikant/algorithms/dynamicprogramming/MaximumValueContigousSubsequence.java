package shrikant.algorithms.dynamicprogramming;

import static java.lang.Integer.*;
import static shrikant.algorithms.dynamicprogramming.MVCS.printSequence;
import static shrikant.algorithms.dynamicprogramming.MVCSWithoutThreeConsecutiveIntegers.getSumWithoutThreConsecutive;
import static shrikant.algorithms.dynamicprogramming.MVCSWithoutTwoConsecutiveIntegers.*;

public class MaximumValueContigousSubsequence {
    // Given an array of integer, find the contiguous subsequence A(i) to A(j)
    // for which the sum is maximum.
    public static void main(String[] args) {
//        doMaximumValueContigousSubsequence();
//        doMaximumValueContiguousSubsequenceWithoutTwoConsecutiveIntegers();
        System.out.println("Value is " + getSumWithoutThreConsecutive(new int[]{1, 2, 4, }));
    }

    private static void doMaximumValueContiguousSubsequenceWithoutTwoConsecutiveIntegers() {
        String textSumOfContiguousSeqWithoutContigousNumbers = "Global Max sum is (without two contiguous numbers) : ";
        System.out.println(textSumOfContiguousSeqWithoutContigousNumbers + getSum(new int[]{-1, 2, 4, 5, 9, 4}));
    }

    private static void doMaximumValueContigousSubsequence() {
        System.out.println("Global Max sum is : " + MVCS.sum(new int[]{18, 4, -19, 3, 5, 6, -10}));
        System.out.println("and sequence is : ");
        printSequence();
    }
}

class MVCS {
    static int[] sumSeq;
    static int globalMaxIndex;
    static int[] sequenceFromArg;

    // Following algorithm doesn't work if all the numbers are negative
    // There should be some way to detect all the numbers are negative
    // Either we can add that logic in the core logic or we can have
    // an extra checkup while traversing the list either by maintaining
    // some kind of variable which keeps track of whether all the numbers
    // in the array are negative or not.
    public static int sum(int[] sequence) {
        sequenceFromArg = sequence;
        int globalMaxSum = 0;
        globalMaxIndex = -1;
        sumSeq = new int[sequence.length];
        sumSeq[0] = sequence[0] > 0 ? sequence[0] : 0;
        for (int i = 1; i < sequence.length; i++) {
            int sum = sequence[i] + sumSeq[i - 1];
            sumSeq[i] = sum > 0 ? sum : 0;
            globalMaxIndex = sumSeq[i] > globalMaxSum ? i : globalMaxIndex;
            globalMaxSum = max(sumSeq[i], globalMaxSum);
        }
        return globalMaxSum;
    }

    public static void printSequence() {
        for (int i = globalMaxIndex; i >= 0; i--) {
            if (sumSeq[i] > 0) {
                System.out.println(sequenceFromArg[i]);
            } else {
                break;
            }
        }
    }
}

class MVCSWithoutTwoConsecutiveIntegers {
    // Finding the sum of the maximum value contiguous subsequence
    // where two integers can't be contiguous
    static int[] sumSequence;

    public static int getSum(int[] sequence) {
        if (sequence.length == 1)
            return sequence[0];
        if (sequence.length == 2)
            return max(sequence[0], sequence[1]);

        sumSequence = new int[sequence.length];
        sumSequence[0] = sequence[0];
        sumSequence[1] = max(sequence[0], sequence[1]);

        for (int i = 2; i < sequence.length; i++) {
            sumSequence[i] = max(sequence[i] + sumSequence[i - 2], max(sumSequence[i - 1], sequence[i]));
        }
        return sumSequence[sumSequence.length - 1];
    }
}

class MVCSWithoutThreeConsecutiveIntegers {
    static int[] sumseq;

    public static int getSumWithoutThreConsecutive(int[] sequence) {
        if (sequence.length == 0 || sequence == null)
            return 0;
        if (sequence.length == 1)
            return sequence[0];
        if (sequence.length == 2)
            return max(sequence[0], max(sequence[1], sequence[0] + sequence[1]));
        if (sequence.length == 3)
            return max(sequence[0], max(sequence[1], max(sequence[2], max(sequence[0] + sequence[1], sequence[1] + sequence[2]))));
        sumseq = new int[sequence.length];

        sumseq[0] = sequence[0];
        sumseq[1] = max(sequence[0], max(sequence[1], sequence[0] + sequence[1]));
        sumseq[2] = max(sequence[0], max(sequence[1], max(sequence[2], max(sequence[0] + sequence[1], sequence[1] + sequence[2]))));

        for (int i = 3; i < sequence.length; i++) {
            sumseq[i] = max(sequence[i], max(sequence[i] + sumseq[i-2], sequence[i] + sequence[i-1] + sumseq[i-3]));
        }
        return sumseq[sumseq.length -1];
    }
}


