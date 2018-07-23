package shrikant.datastructure.queues;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    // There was one more question regarding coding wars
    // and this question can be done with the help of the stack
    // I don't know why I followed this approach

    public static void main(String[] args) {
//        String[] testArr = new String[]{"a", "b","b","d", "b","e","c","c","c","e", "e"};
//        String[] outArr = getShrunkArray(testArr, 3);
//        System.out.println(Arrays.toString(outArr));
        Character[] some = new Character[]{'a', 'b'};
        System.out.println(some.toString());
//        String.valueOf
    }


    static String[] getShrunkArray(String[] inputArray, int burstLength) {
        return shrunkArray(0, inputArray, burstLength);
    }

    public static String[] shrunkArray(int index, String[] inputArray, int burstLength) {
        if (index >= inputArray.length - 1 || inputArray.length == 1)
            return inputArray;
        int burstCount = 1;
        String prevChar = inputArray[index];
        for (int i = index + 1; i < inputArray.length; i++) {
            if (inputArray[i] == prevChar) {
                burstCount++;
            } else {
                if (burstCount >= burstLength) {
                    return reduceString(inputArray, burstLength, burstCount, i);
                }
                burstCount = 1;
            }
            if (i == inputArray.length - 1 && burstCount >= burstLength){
                return reduceString(inputArray, burstLength, burstCount, i + 1);
            }
            prevChar = inputArray[i];
        }
        return inputArray;
    }

    private static String[] reduceString(String[] inputArray, int burstLength, int burstCount, int i) {
        int tempCount = 0;
        while (tempCount < burstCount) {
            inputArray = removeElement(inputArray, i - tempCount - 1);
            tempCount++;
        }
        return shrunkArray(i - (burstCount + 1), inputArray, burstLength);
    }

    public static String[] removeElement(String[] a, int del) {
        String[] b = new String[a.length - 1];
        System.arraycopy(a, 0, b, 0, del);
        System.arraycopy(a, del + 1, b, del, b.length - del);
        return b;
    }
}
