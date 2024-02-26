package algorithms.d_and_c;

import java.util.Arrays;

/**
 * Class to find the median of an array using the Median of Medians algorithm.
 */
public class MedianOfMedians {
    
    /**
     * Main method to demonstrate finding the median of an array.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {11, 6, 6, 3, 9, 14, 66, 2};
        
        findMedian(arr);
    }
    
    /**
     * Method to find the median of an array.
     * @param arr The input array.
     */
    private static void findMedian(int[] arr) {
        int median = findMedianUtil(arr, (arr.length) / 2 + 1, 0, arr.length - 1);
        
        System.out.printf("Median = %d\n", median);
    }
    
    /**
     * Utility method to recursively find the median using the Median of Medians algorithm.
     * @param arr The input array.
     * @param k The kth smallest element to find.
     * @param low The lower index of the current subarray.
     * @param high The higher index of the current subarray.
     * @return The kth smallest element (median).
     */
    private static int findMedianUtil(int[] arr, int k, int low, int high) {
        int m = partition(arr, low, high);
        
        int length = m - low + 1;
        if (length == k) {
            return arr[m];
        }
        if (length > k) {
            return findMedianUtil(arr, k, low, m - 1);
        } else {
            return findMedianUtil(arr, k - length, m + 1, high);
        }
    }
    
    /**
     * Method to partition the array.
     * @param arr The input array.
     * @param low The lower index of the subarray to partition.
     * @param high The higher index of the subarray to partition.
     * @return The index of the pivot element after partitioning.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = getPivotValue(arr, low, high);
        
        while (low < high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }
            
            if (arr[low] == arr[high]) {
                low++;
            }
            // Swap
            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }
        return high;
    }
    
    /**
     * Method to get the pivot value for partitioning.
     * @param arr The input array.
     * @param low The lower index of the subarray.
     * @param high The higher index of the subarray.
     * @return The pivot value.
     */
    private static int getPivotValue(int[] arr, int low, int high) {
        if (high - low + 1 <= 9) {
            Arrays.sort(arr);
            return arr[arr.length / 2];
        }
        
        int[] temp;
        int[] medians = new int[(int) Math.ceil((double) (high - low + 1) / 5)];
        int medianIndex = 0;
        
        while (high >= low) {
            temp = new int[Math.max(5, high - low + 1)];
            
            for (int i = 0; i < temp.length && low <= high; i++) {
                temp[i] = arr[low];
                low++;
            }
            
            Arrays.sort(temp);
            
            medians[medianIndex] = temp[temp.length / 2];
            medianIndex++;
        }
        return getPivotValue(medians, 0, medians.length - 1);
    }
}
