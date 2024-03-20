package algorithms.w3schools;

public class RadixSort {
    
    /**
     * Main method: Entry point of the program.
     */
    public static void main(String[] args) {
        int[] myArray = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.print("Original array: ");
        for (int val : myArray) {
            System.out.print(val + " ");
        }
        System.out.println();
        
        // 2D array to hold numbers according to their digits (0-9)
        int[][] radixArray = new int[10][myArray.length];
        // Array to keep track of counts of numbers for each digit
        int[] counts = new int[10];
        // Find the maximum value in the array to determine the maximum number of digits
        int maxVal = findMax(myArray);
        // Initialize the exponent for radix calculation
        int exp = 1;
        
        // Perform radix sort for each digit
        while (maxVal / exp > 0) {
            // Distribute numbers into the radix array based on their digit
            for (int val : myArray) {
                int radixIndex = (val / exp) % 10;
                radixArray[radixIndex][counts[radixIndex]] = val;
                counts[radixIndex]++;
            }
            
            // Gather numbers from the radix array into the original array
            int pos = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    myArray[pos] = radixArray[i][j];
                    pos++;
                }
                counts[i] = 0;
            }
            
            // Move to the next digit
            exp *= 10;
        }
        
        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int val : myArray) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    /**
     * Find the maximum value in an array.
     *
     * @param arr The input array
     * @return The maximum value in the array
     */
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
}
