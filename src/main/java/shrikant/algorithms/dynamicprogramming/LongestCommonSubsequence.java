package shrikant.algorithms.dynamicprogramming;

import com.sun.deploy.util.StringUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.Integer.*;
import static shrikant.algorithms.dynamicprogramming.LCS.getLcs;
import static shrikant.algorithms.dynamicprogramming.LCS.lenLcs;

public class LongestCommonSubsequence {
    // This is longest common subsequence problem
    // Try to find the longest common subsequence length
    // Try to print the longest common subsequence
    public static void main(String[] args) {
        int lenOfLcs = lenLcs("abcbdab", "bdcaba");
        System.out.println("Length of longest common subsequence " + getLcs() + " is : " + lenOfLcs);
    }
}

class LCS {
    // globally created array of integer by default has value 0
    // and if the array is of String or any class then the initialization of the
    // array would be done by the default value null

    static int lcsTab[][];
    // here is used stack and then i used queue, I thought the loop is from back of strings
    // to front so when I will return stack.tostring it will return in right order
    // but that didn't happen because stack.tostring() return in the order of insertion which
    // is first in and the same happens with the queue also, but queue is already first in.
    // and in the queue also we found the same behaviour need to find a way to build string.
    static Queue<String> stringQueue;

    public static int lenLcs(String first, String second) {
        lcsTab = new int[first.length() + 1][second.length() + 1];
        stringQueue = new LinkedList<String>();
        int hitCounter = 0; // suppose to increase only when the count of hit increases
        for (int i = first.length() - 1; i >= 0; i--) {
            for (int j = second.length() - 1; j >= 0; j--) {
                lcsTab[i][j] = areCharsEqual(first, second, i, j) ? 1 + lcsTab[i + 1][j + 1] : max(lcsTab[i][j + 1], lcsTab[i + 1][j]);
                if (lcsTab[i][j] > hitCounter){
                    hitCounter = lcsTab[i][j];
                    stringQueue.offer(String.valueOf(second.charAt(j)));
                }
            }
        }
        return lcsTab[0][0];
    }

    public static String getLcs(){
        return stringQueue.toString();
    }

    private static boolean areCharsEqual(String first, String second, int i, int j) {
        return first.charAt(i) == second.charAt(j);
    }
}