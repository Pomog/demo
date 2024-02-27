package algorithms.greedy;

import java.util.Arrays;

/**
 * This class implements the Fractional Knapsack algorithm to find the maximum profit possible.
 */
public class FractionalKnapsack {
    
    /**
     * Finds the maximum profit possible using the Fractional Knapsack algorithm.
     *
     * @param wt       array of weights of items
     * @param val      array of values of items
     * @param capacity capacity of the knapsack
     * @return maximum profit possible
     */
    public static double getMaxValue(int[] wt, int[] val, int capacity) {
        // Create an array to store items
        Item[] items = new Item[wt.length];
        
        // Populate the items array with Item objects
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(wt[i], val[i], i);
        }
        
        // Sort items array based on their cost (value per unit weight)
        Arrays.sort(items, (o1, o2) -> o2.cost.compareTo(o1.cost));
        
        // Initialize totalValue to store the maximum profit
        double totalValue = 0d;
        
        // Iterate through items array to fill the knapsack
        for (Item item : items) {
            int curWt = (int) item.wt;
            int curVal = (int) item.val;
            
            // If adding the entire item is possible
            if (capacity - curWt >= 0) {
                capacity -= curWt;  // Reduce capacity
                totalValue += curVal;  // Add value of the item to totalValue
            } else {
                // Add fraction of the item to fill the knapsack
                double fraction = (double) capacity / (double) curWt;
                totalValue += curVal * fraction;
                break;  // Knapsack is full, exit loop
            }
        }
        
        // Return the maximum profit
        return totalValue;
    }
    
    /**
     * The main method to test the Fractional Knapsack algorithm.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Input data
        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;
        
        // Get the maximum profit using Fractional Knapsack algorithm
        double maxValue = getMaxValue(wt, val, capacity);
        
        // Print the result
        System.out.printf("The MAX profit possible = %.2f\n", maxValue);
    }
}
