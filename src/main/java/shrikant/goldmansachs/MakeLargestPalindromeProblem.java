package shrikant.goldmansachs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MakeLargestPalindromeProblem {

    public static void main(String[] args) {
        System.out.println(MakeLargestPalindrome.largestPalindrome("uuisdfafh;kldj;fa;lkjaf;j;ldjf;lajdoiweiorqwerdnfspjfdpqweriuyqwtldfxgoooiiiiibb"));
    }
}

class MakeLargestPalindrome {
    // The question is to make the largest palindrome out of any given string.
    // provided as the input.

    static HashMap<String, Integer> map;
    static boolean onceOnly = false;

    public static String largestPalindrome(String input) {

        if (onceOnly == false) {
            map = new HashMap<String, Integer>();
            onceOnly = true;
        }

        scanInputToAddString(input, map);

        String longestPalindrome = buildPalindrome(map);

        return longestPalindrome;
    }

    private static String buildPalindrome(HashMap<String, Integer> map) {
        String palindrome = "";
        String charInMid = "";
        if (map == null || map.isEmpty())
            return "";
        for (Entry entry :
                map.entrySet()) {
            Integer charCount = (Integer) entry.getValue();
            if (charCount > 1) {
                if (!isEven(charCount))
                    charInMid = (String) entry.getKey();
                palindrome = addCharsInMid(palindrome, (String) entry.getKey(), isEven(charCount) ? charCount : charCount - 1);
            }else{
                charInMid = (String) entry.getKey();
            }
        }

        return addCharsInMid(palindrome, charInMid, 1);
    }

    private static String addCharsInMid(String palindrome, String key, Integer charCount) {
        if (key == null || key == "")
            return "";
        if (charCount <= 0)
            return palindrome;
        int length = palindrome.length();
        if (length <= 1)
            return addCharsInMid(palindrome + key, key, --charCount);
        int mid = (length / 2) - 1;
        palindrome = palindrome.substring(0, mid+ 1) + key + palindrome.substring(mid+1);
        return addCharsInMid(palindrome, key, --charCount);
    }

    private static void scanInputToAddString(String input, HashMap<String, Integer> map) {
        for (char currChar :
                input.toCharArray()) {
            addCharToMap(currChar, map);
        }
    }

    private static void addCharToMap(char currChar, HashMap<String, Integer> map) {
        String keyInString = String.valueOf(currChar);
        Integer charCount = map.get(keyInString);
        charCount = charCount == null ? 1 : ++charCount;
        map.put(keyInString, charCount);
    }

    private static boolean isEven(int number) {
        return (number % 2) == 0;
    }


}