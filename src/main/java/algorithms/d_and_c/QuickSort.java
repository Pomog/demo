package algorithms.d_and_c;

/**
 * Class implementing QuickSort algorithm for sorting an integer array.
 */
public class QuickSort {
    
    /**
     * Main method to demonstrate QuickSort.
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Input array
        int[] arr = {11, 6, 6, 3, 9, 14, 66, 2};
        
        // Sorting the array using QuickSort
        quickSort(arr, 0, arr.length - 1);
        
        // Printing the sorted array
        System.out.println("FINAL QuickSort");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    /**
     * Method to perform QuickSort on the given array.
     * @param arr The array to be sorted.
     * @param lb The lower bound index of the array.
     * @param ub The upper bound index of the array.
     */
    private static void quickSort(int[] arr, int lb, int ub) {
        int index;
        
        // Recursively sort partitions if lb is less than ub
        if (lb < ub) {
            index = partition(arr, lb, ub);
            quickSort(arr, lb, index - 1);
            quickSort(arr, index + 1, ub);
        }
    }
    
    /**
     * Method to partition the array for QuickSort.
     * @param arr The array to be partitioned.
     * @param lb The lower bound index of the partition.
     * @param ub The upper bound index of the partition.
     * @return The index of the partition element.
     */
    private static int partition(int[] arr, int lb, int ub) {
        // Choosing the pivot element
        int pivot = arr[lb];
        int left = lb;
        int right = ub;
        
        // Partitioning the array
        while (left < right) {
            // Moving left pointer until an element greater than pivot is found
            while (arr[left] <= pivot && left < arr.length - 1) {
                left++;
            }
            // Moving right pointer until an element smaller than pivot is found
            while (arr[right] > pivot && right > 0) {
                right--;
            }
            // Swap the elements if left pointer is less than right pointer
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        
        // Swap the pivot element with the element at right index
        int temp = arr[lb];
        arr[lb] = arr[right];
        arr[right] = temp;
        
        // Return the index of the partition element
        return right;
    }
}
