package algorithms.named;

/**
 * Kadane's Algorithm for finding the maximum subarray sum.
 */
public class Kadane {
    /**
     * Main method to demonstrate Kadane's Algorithm.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = {-2, -1, 3, -2, 4, 3, -3, 5};
        
        // Find and print the maximum subarray sum
        System.out.printf("The maximum subarray sum is - %d\n", maxSumSubArray(arr));
    }
    
    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * @param arr The input array.
     * @return The maximum subarray sum.
     */
    private static int maxSumSubArray(int[] arr) {
        // Initialize variables to track global maximum and local maximum
        int globalMax = arr[0];
        int localMax = arr[0];
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Calculate the local maximum by choosing between the current element
            // and the sum of the current element and the previous local maximum
            localMax = Math.max(localMax + arr[i], arr[i]);
            
            // Update the global maximum if the local maximum is greater
            globalMax = Math.max(globalMax, localMax);
        }
        
        // Return the global maximum subarray sum
        return globalMax;
    }
}
