package shrikant.datastructure.bitoperation;

public class XorHelper {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 2};
        int temp = arr[0];
        System.out.println(temp);
        for (int i = 1; i < arr.length; i++) {
            temp = temp ^ arr[i];
            System.out.println(temp);
        }
        System.out.println("Value is " + temp);
    }
}
