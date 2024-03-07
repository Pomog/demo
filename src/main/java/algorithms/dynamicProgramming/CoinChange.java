package algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 3, 5, 2};
        int len = coins.length;
        int total = 7;
        
        int min = minCoins(coins, len, total);
        System.out.printf("Min coins needed, Recursive: %d\n", min);
        
        int minTD = minCoinsTopDown(coins, len, total, new HashMap<Integer, Integer>());
        System.out.printf("Min coins needed, Top to Bottom: %d\n", minTD);
        
        int minBT = minCoinsBottomToTop(coins, len, total);
        System.out.printf("Min coins needed, Bottom Up: %d\n", minBT);
    }
    
    // Bottom Up
    private static int minCoinsBottomToTop(int[] coins, int len, int total) {
        int[] arr = new int[total + 1];

        Arrays.fill(arr, total + 1);
        arr[0] = 0;
        
        for (int i = 0; i < len; i++) {
            // target amount
            for (int j = 1; j < arr.length; j++) {
                if (coins[i] <= j) {
                    if (1 + arr[j - coins[i]] < arr[j]) {
                        arr[j] = 1 + arr[j - coins[i]];
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));
        return arr[total];
    }
    
    // Top to Bottom
    private static int minCoinsTopDown(int[] coins, int len, int total, HashMap<Integer, Integer> hashMap) {
        if (total == 0) {
            return 0;
        }
        
        if (hashMap.containsKey(total)) {
            return hashMap.get(total);
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (coins[i] <= total) {
                int subResult = minCoinsTopDown(coins, len, total - coins[i], hashMap);
                if (subResult != Integer.MAX_VALUE && subResult + 1 < result) {
                    result = subResult + 1;
                }
            }
        }
        hashMap.put(total, result);
        return result;
    }
    
    
    // recursive
    private static int minCoins(int[] coins, int len, int total) {
        if (total == 0) {
            return 0;
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (coins[i] <= total) {
                int subResult = minCoins(coins, len, total - coins[i]);
                if (subResult != Integer.MAX_VALUE && subResult + 1 < result) {
                    result = subResult + 1;
                }
            }
        }
        return result;
    }
}
