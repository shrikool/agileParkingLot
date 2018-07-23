package shrikant.datastructure.search.binarysearch;

public class SearchInRotatedSortedArray {
    // given a sorted array of n integers that has been rotated an unknown numbers
    // of times give a O(logN) alogorithm that finds element in the array
    // e.g find 5 in 15 16 19 20 25 1 3 4 5 6 7 8 9 10 14

    public static void main(String[] args) {
//        int[] arr = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 6, 7, 8, 9, 10, 14};
        int[] arr = new int[]{0};
        int index = rotatedBinarySearch(arr, 0, arr.length - 1, 0, 0);
        System.out.println("Index is " + index);
    }

    public static int rotatedBinarySearch(int[] arr, int start, int end, int data, int iteration) {
        System.out.println("Iteration " + iteration + "start" + start + "end" + end);
        if (start == end) {
            if (arr[start] == data)
                return start;
            else
                return -1;
        }
        if (end == start + 1) {
            if (arr[start] == data)
                return start;
            else if (arr[end] == data)
                return end;
            return -1;
        }
        int mid = start + ((end - start) / 2);
        System.out.println("Mid evaluated to : " + mid);
        if (arr[mid] == data) {
            return mid;
        }
        if ((arr[start] < arr[mid - 1] && data >= arr[start] && start != mid - 1) // if the left half is continously increasing and number is there
                || (arr[start] >= arr[mid - 1] && data <= arr[mid - 1] && start != mid - 1)) { // left half is rotated one and number is there
            System.out.println("Going in left half");
            return rotatedBinarySearch(arr, start, mid - 1, data, iteration + 1);
        } else {
            System.out.println("Going in right half");
            return rotatedBinarySearch(arr, mid + 1, end, data, iteration + 1);
        }
    }

}
