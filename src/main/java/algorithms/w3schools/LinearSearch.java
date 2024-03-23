package algorithms.w3schools;

import java.util.stream.IntStream;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 9, 5};
        int targetVal = 9;
        
        int result = linearSearchWithStream(arr, targetVal);
        
        if (result != -1) {
            System.out.println("Value " + targetVal + " found at index " + result);
        } else {
            System.out.println("Value " + targetVal + " not found");
        }
    }
    
    public static int linearSearch(int[] arr, int targetVal) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == targetVal) {
                return i;
            }
        }
        return -1;
    }
    
    public static int linearSearchWithStream(int[] arr, int targetVal) {
        return IntStream.range(0, arr.length).
                filter(i -> arr[i] == targetVal).
                findFirst().
                orElse(-1);
    }
}

