package algorithms.w3schools;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] my_array = {64, 34, 25, 12, 22, 11, 90, 5};
        int n = my_array.length;
        
        for (int i = 0; i < n; i++) {
            int min_index = i;
            for (int j = i+1; j < n; j++) {
                if (my_array[j] < my_array[min_index]) {
                    min_index = j;
                }
            }
            int temp = my_array[i];
            my_array[i] = my_array[min_index];
            my_array[min_index] = temp;
        }
        
        System.out.println("Sorted array: ");
        Arrays.stream(my_array).forEach(System.out::println);
    }
}