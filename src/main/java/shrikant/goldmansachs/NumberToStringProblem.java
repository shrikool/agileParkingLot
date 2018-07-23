package shrikant.goldmansachs;

import java.util.*;

import static shrikant.goldmansachs.NumberToString.numberToString;

public class NumberToStringProblem {

    public static void main(String[] args) {
        int number =  234890;
        System.out.println("The number " + number + " is called " + numberToString(number));
        System.out.println(number);
    }
}


class NumberToString {

    public static String numberToString(int number) {
        if (number == 0)
            return "zero";

        Stack<String> nameStack = new Stack<String>();
        int tempNumber = number;
        int advanceByThousand = 0;
        while (tempNumber != 0) {
            nameStack.push(getNameUnderHundred(tempNumber % 1000));
            if ((tempNumber / 1000) > 0)
                nameStack.push(getIndexName().get(advanceByThousand++));
            tempNumber = tempNumber / 1000;
        }

        return getNameFromStack(nameStack);
    }

    private static String getNameUnderHundred(int tempNumber) {
        Stack<String> name = new Stack<String>();

        double powerToTen = 0;
        while (tempNumber != 0) {
            name.push(getMap().get((int) ((tempNumber % 10) * Math.pow(10, powerToTen++))));
            tempNumber = tempNumber / 10;
        }

        return getNameFromStack(name);
    }

    private static String getNameFromStack(Stack<String> name) {
        StringBuilder nameString = new StringBuilder();
        while (!name.isEmpty()) {
            nameString.append(name.pop());
            nameString.append(" ");
        }

        return nameString.toString().trim();
    }


    public static Map<Integer, String> getMap() {
        HashMap<Integer, String> integerStringHashMap = new HashMap<Integer, String>();
        integerStringHashMap.put(1, "one");
        integerStringHashMap.put(2, "two");
        integerStringHashMap.put(3, "three");
        integerStringHashMap.put(4, "four");
        integerStringHashMap.put(5, "five");
        integerStringHashMap.put(6, "six");
        integerStringHashMap.put(7, "seven");
        integerStringHashMap.put(8, "eight");
        integerStringHashMap.put(9, "nine");
        integerStringHashMap.put(10, "ten");
        integerStringHashMap.put(11, "eleven");
        integerStringHashMap.put(12, "twelwe");
        integerStringHashMap.put(13, "thirteen");
        integerStringHashMap.put(14, "fourteen");
        integerStringHashMap.put(15, "fifteen");
        integerStringHashMap.put(16, "sixteen");
        integerStringHashMap.put(17, "seventeen");
        integerStringHashMap.put(18, "eighteen");
        integerStringHashMap.put(19, "nineteen");
        integerStringHashMap.put(20, "twenty");
        integerStringHashMap.put(30, "thirty");
        integerStringHashMap.put(40, "fourty");
        integerStringHashMap.put(50, "fifty");
        integerStringHashMap.put(60, "sixty");
        integerStringHashMap.put(70, "seventy");
        integerStringHashMap.put(80, "eighty");
        integerStringHashMap.put(90, "ninty");
        integerStringHashMap.put(100, "one hundred");
        integerStringHashMap.put(200, "two hundred");
        integerStringHashMap.put(300, "three hundred");
        integerStringHashMap.put(400, "four hundred");
        integerStringHashMap.put(500, "five hundred");
        integerStringHashMap.put(600, "six hundred");
        integerStringHashMap.put(700, "seven hundred");
        integerStringHashMap.put(800, "eight hundred");
        integerStringHashMap.put(900, "nine hundred");
        return integerStringHashMap;
    }

    public static List<String> getIndexName() {
        List<String> posName = new ArrayList<String>();
        posName.add("thousand");
        posName.add("million");
        posName.add("billion");
        return posName;
    }
}
