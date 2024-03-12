package algorithms.w3schools;

import java.util.Arrays;

public class MinValueOfArray {
    public static void main(String[] args) {
        int[] my_array = {7, 12, 9, 4, 11,-5};
        int minVal = my_array[0];
        
        
        minVal = getMinVal(my_array);
        
        int min = my_array[0];
        int minValStream = Arrays.stream(my_array).min().getAsInt();
        System.out.println("Lowest value with stream API: " + minValStream);
        System.out.println("Lowest value: " + minVal);
        
        bubbleSort(my_array);
    }
    
    private static int getMinVal(int[] my_array) {
        int minVal = my_array[0];
        for (int i : my_array) {
            if (i < minVal) {
                minVal = i;
            }
        }
        return minVal;
    }
    
    private static void bubbleSort(int[] my_array) {
        int n = my_array.length;
        
        for (int i = 0; i < n-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n-i-1; j++) {
                if (my_array[j] > my_array[j+1]) {
                    int temp = my_array[j];
                    my_array[j] = my_array[j+1];
                    my_array[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        
        System.out.printf("Sorted array: %s\n", Arrays.toString(my_array));
    }
    
}
