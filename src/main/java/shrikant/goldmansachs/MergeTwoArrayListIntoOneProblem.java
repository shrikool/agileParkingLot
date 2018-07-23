package shrikant.goldmansachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoArrayListIntoOneProblem {
    // Merge two array list into one without the use of hash map and set and any specialised method.

    public static void main(String[] args) {
        List<Integer> numberListOne = new ArrayList<Integer>();
        numberListOne.add(1);
        numberListOne.add(1);
        numberListOne.add(2);

        List<Integer> numberListTwo = new ArrayList<Integer>();
        numberListTwo.add(5);
        numberListTwo.add(4);
        numberListTwo.add(2);
        numberListTwo.add(6);
        numberListTwo.add(7);

        List<Integer> finalList = MergeTwoArrayListIntoOne.merge(numberListOne, numberListTwo);
        System.out.println("Final List is ");
        for (int current :
                finalList) {
            System.out.println(current);
        }
    }
}

class MergeTwoArrayListIntoOne {
    public static List<Integer> merge(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> newList = new ArrayList<Integer>();
        int numberOfDuplicates = 0;

        for (Integer current :
                listOne) {
            numberOfDuplicates = insertIntoNewList(newList, numberOfDuplicates, current);
        }

        for (Integer current :
                listTwo) {
            numberOfDuplicates = insertIntoNewList(newList, numberOfDuplicates, current);
        }

        newList.addAll(listTwo);
        return newList;
    }

    private static int insertIntoNewList(List<Integer> newList, int numberOfDuplicates, Integer current) {
        if (!newList.contains(current)) {
            newList.add(current);
        }
        else{
            numberOfDuplicates++;}
        return numberOfDuplicates;
    }
}
