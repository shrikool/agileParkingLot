package shrikant.datastructure.stack;

import static shrikant.datastructure.stack.SpanByIteration.getMaxSpanCount;

public class Span {

    public static int[] makeTheArgument(){
        return new int[]{6, 3, 4, 5, 2};
    }

    public static void main(String[] args) {
        String result = String.format("Max Span count is %d", getMaxSpanCount(makeTheArgument()));
        System.out.println(result);
    }
}

class SpanByIteration{
    public static int getMaxSpanCount(int[] arr){
        int maxSpanCount = 0;
        for (int i =0 ; i <arr.length; i++){
            int tempCount = 0;
            for (int j = i ; j >= 0 ; j--){
                if (arr[j] <= arr[i]){
                    tempCount++;
                }
            }
            maxSpanCount = maxSpanCount >= tempCount ? maxSpanCount : tempCount;
        }
        return maxSpanCount;
    }

}