package shrikant.algorithms.searching;

import java.util.Arrays;

public class Searching1 {
    // given a array of 2n integers in the following format
    // a1a2a3a4b1b2b3b4
    // Shuffle the array to a1b1a2b2a3b3a4b4a5b5
    // without any extra memory

    public static void main(String[] args) {
        int[] initialArray = new int[]{1, 2, 3, 4, 11, 12, 13, 14};
        shuffleArray(initialArray, 0, initialArray.length - 1);
        System.out.println(Arrays.toString(initialArray));
    }

    private static void shuffleArray(int[] initialArray, int start, int end) {
        if (end - start <= 1)
            return;
        int mid = start + ((end - start) / 2);
        int startToSwap = start + ((mid - start) / 2) + 1;
        swapRange(initialArray, startToSwap, mid + 1);
        shuffleArray(initialArray, start, mid);
        shuffleArray(initialArray, mid + 1, end);
    }

    private static void swapRange(int[] initialArray, int start, int mid) {
        int tmid = mid;
        int tstart = start;
        while (tstart < mid) {
            swapInt(initialArray, tstart++, tmid++);
        }
    }

    private static void swapInt(int[] initialArray, int from, int to) {
        int temp = initialArray[from];
        initialArray[from] = initialArray[to];
        initialArray[to] = temp;
    }
}
