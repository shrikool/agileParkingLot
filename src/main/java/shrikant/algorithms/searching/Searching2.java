package shrikant.algorithms.searching;

public class Searching2 {
    // given an array a[] , find the maximum (j - i) such that a[j] > a[i] for example for input
    // {34, 8, 10, 3, 2, 80, 30, 33, 1} and output is 6 j=7 and i=1
    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int maxDiffInIndex = findMaxDif(arr);
        System.out.println("Maximum difference is : " + maxDiffInIndex);
    }

    private static int findMaxDif(int[] arr) {
        int[] maxElemArr = new int[arr.length];
        int[] minElemArr = new int[arr.length];
        int localMin = Integer.MAX_VALUE;
        int localMax = Integer.MIN_VALUE;

        for (int index = 0; index < arr.length; index++) {
            localMin = Math.min(localMin, arr[index]);
            minElemArr[index] = localMin;
        }

        for (int index = arr.length - 1; index >= 0; index--) {
            localMax = Math.max(localMax, arr[index]);
            maxElemArr[index] = localMax;
        }

        int minIndex = 0;
        int maxIndex = 0;
        int maxDiff = -1;

        while (minIndex <= maxIndex && minIndex < arr.length && maxIndex < arr.length) {
            if (minElemArr[minIndex] < maxElemArr[maxIndex]) {
                maxDiff = Math.max(maxDiff, maxIndex - minIndex);
                maxIndex++;
            } else {
                minIndex++;
            }
        }
        return maxDiff;
    }


}
