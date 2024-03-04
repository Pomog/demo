package algorithms.dynamicProgramming;

import java.util.Arrays;

/**
 * Implementation of the 0/1 Knapsack problem using dynamic programming.
 */
public class Knapsack01 {
    
    /**
     * Main method to test the implementation.
     */
    public static void main(String[] args) {
        int[] weight = {7, 4, 4};
        int[] price = {15, 8, 8};
        
        int capacity = 10;
        
        int n = weight.length;
        int[][] values = new int[n + 1][capacity + 1];
        
        // Initialize values array with -1
        for (int i = 0; i <= n; i++) {
            Arrays.fill(values[i], -1);
        }
        
        // Solve knapsack problem using top-down approach
        System.out.printf("Top to Down. %d\n", getMaxProfitTopToBottom(weight, price, n, capacity, values));
        
        // Solve knapsack problem using bottom-up approach
        System.out.printf("Bottom to Top. %d\n", getMaxProfitBottomToTop(weight, price, n, capacity));
    }
    
    /**
     * Solves the knapsack problem using bottom-up dynamic programming approach.
     *
     * @param weight   array containing weights of items
     * @param price    array containing prices of items
     * @param n        number of items
     * @param capacity knapsack capacity
     * @return         maximum profit that can be obtained
     */
    private static int getMaxProfitBottomToTop(int[] weight, int[] price, int n, int capacity) {
        int[][] values = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    values[i][j] = 0;
                } else {
                    int incl = 0, excl = 0;
                    if (weight[i - 1] <= j) {
                        incl = price[i - 1] + values[i - 1][j - weight[i - 1]];
                    }
                    excl = values[i - 1][j];
                    values[i][j] = Math.max(incl, excl);
                }
            }
        }
        
        // Print values table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                System.out.print(values[i][j] + "\t");
            }
            System.out.println();
        }
        
        return values[n][capacity];
    }
    
    /**
     * Solves the knapsack problem using top-down dynamic programming approach.
     *
     * @param weight   array containing weights of items
     * @param price    array containing prices of items
     * @param n        number of items
     * @param capacity knapsack capacity
     * @param values   2D array to store computed values for dynamic programming
     * @return         maximum profit that can be obtained
     */
    private static int getMaxProfitTopToBottom(int[] weight, int[] price, int n, int capacity, int[][] values) {
        if (n == 0 || capacity == 0) {
            values[n][capacity] = 0;
            return values[n][capacity];
        }
        
        if (values[n][capacity] != -1) {
            return values[n][capacity];
        }
        
        int incl = 0, excl = 0;
        if (weight[n - 1] <= capacity) {
            incl = price[n - 1] + getMaxProfitTopToBottom(weight, price, n - 1, capacity - weight[n - 1], values);
        }
        
        excl = getMaxProfitTopToBottom(weight, price, n - 1, capacity, values);
        
        values[n][capacity] = Math.max(incl, excl);
        
        return values[n][capacity];
    }
}
