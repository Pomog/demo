package algorithms.d_and_c;

/**
 * A class implementing the merge sort algorithm.
 */
public class MergeSort {
    
    /**
     * Main method to demonstrate merge sort on an array.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        int[] arr = {11, 6, 6, 3, 9, 14, 66, 2};
        int len = arr.length;
        
        mergeSort(arr, 0, len-1);
        
        System.out.println("FINAL");
        for (int i = 0; i<len; i++){
            System.out.println(arr[i]);
        }
        
    }
    
    /**
     * Recursive method to perform merge sort on an array.
     * @param arr The array to be sorted.
     * @param l The index of the left boundary of the array/subarray.
     * @param u The index of the right boundary of the array/subarray.
     */
    private static void mergeSort(int[] arr, int l, int u) {
        if (l<u){
            
            int m = (l+u)/2;
            
            // Print left subarray elements
            System.out.println("-----LEFT-------");
            for (int i = l; i<=m; i++){
                System.out.println(arr[i]);
            }
            // Print right subarray elements
            System.out.println("-----RIGHT-------");
            for (int i = m+1; i<=u; i++){
                System.out.println(arr[i]);
            }
            System.out.println("-----------------");
            
            // Recursively sort left and right subarrays
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, u);
            
            // Merge the sorted subarrays
            merge(arr, l, m, u);
            System.out.println("merge");
            for (int i = l; i<=u; i++){
                System.out.println(arr[i]);
            }
        }
    }
    
    /**
     * Merge two sorted subarrays into a single sorted array.
     * @param arr The original array containing elements to be merged.
     * @param l The starting index of the first subarray.
     * @param m The ending index of the first subarray and the starting index of the second subarray.
     * @param u The ending index of the second subarray.
     */
    private static void merge(int[] arr, int l, int m, int u) {
        int n1 = m-l +1;
        int n2 = u-m;
        
        int[] left = new int[n1];
        int[] right = new int[n2];
        
        // Copy elements of left subarray
        for (int i = 0; i<n1; i++){
            left[i] = arr[l+i];
        }
        
        // Copy elements of right subarray
        for (int j = 0; j<n2; j++){
            right[j] = arr[m+1+j];
        }
        
        int i = 0, j = 0, k = l;
        
        // Merge the two subarrays
        while (i<n1 && j< n2) {
            if (left[i] < right[j]){
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of left subarray
        while (i<n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        // Copy remaining elements of right subarray
        while (j<n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}