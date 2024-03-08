package algorithms.dynamicProgramming;

import java.util.Arrays;

public class LongestDecreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {20, 8, 12, 16, 10, 9, 18, 7, 9};
        
        System.out.printf("Longest Decreasing Subsequence, Recursive: %d\n", getLDS(nums, 0, Integer.MAX_VALUE));
        
        int[][] dp = new int[nums.length + 1][nums.length];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        System.out.printf("Longest Decreasing Subsequence, Top to Bottom: %d\n", getLDSTD(nums, -1, 0, dp));
        
        System.out.printf("Longest Decreasing Subsequence, Bottom Up:: %d\n", getLDSBU(nums));
        
    }
    
    // Bottom Up
    private static int getLDSBU(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int[] maxLDS = new int[nums.length];
        Arrays.fill(maxLDS, 1);
        
        int maxSoFar = 1;
        for (int j =1; j<nums.length; j++){
            for (int i=0; i<j; i++){
                if (nums[j]<nums[i]){
                    maxLDS[j]=Math.max(maxLDS[j], maxLDS[i]+1);
                }
            }
            maxSoFar = Math.max(maxSoFar, maxLDS[j]);
        }
        return maxSoFar;
    }
    
    
    // Top to Bottom
    private static int getLDSTD(int[] nums, int prevIdx, int curr, int[][] dp) {
        if (curr == nums.length) {
            return 0;
        }
        
        if (dp[prevIdx + 1][curr] > 0) {
            return dp[prevIdx + 1][curr];
        }
        
        int incl = 0;
        if (prevIdx < 0 || nums[curr] < nums[prevIdx]) {
            incl = 1 + getLDSTD(nums, curr, curr + 1, dp);
        }
        
        int excl = getLDSTD(nums, prevIdx, curr + 1, dp);
        
        dp[prevIdx + 1][curr] = Integer.max(incl, excl);
        
        return dp[prevIdx + 1][curr];
    }
    
    // Top to Bottom
    
    
    // recursive
    private static int getLDS(int[] nums, int i, int prev) {
        if (i == nums.length) {
            return 0;
        }
        
        int incl = 0;
        if (nums[i] < prev) {
            incl = 1 + getLDS(nums, i + 1, nums[i]);
        }
        int excl = getLDS(nums, i + 1, prev);
        
        return Integer.max(incl, excl);
    }
}
