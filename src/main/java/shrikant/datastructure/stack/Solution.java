package shrikant.datastructure.stack;

public class Solution {
    public static void main(String[] args) {
        // there is a optimal substructure here and we need to look into this
        // there will be a couple of two elements at the end of the array
        // where they would be following the relation of greater than or less than
        // if we encounter a third node , than it's our call to whether select the element or not

    }

    public static int getCountOfPossibleTeams(int[] coders) {
        int count = 0;
        for (int i = 0; i < coders.length; i++) {
            for (int j = i + 1; j < coders.length; j++) {
                for (int k = j + 1; k < coders.length; k++) {
                    if ((coders[j] > coders[i] && coders[k] > coders[j])
                            || (coders[j] > coders[k] && coders[i] > coders[j])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
