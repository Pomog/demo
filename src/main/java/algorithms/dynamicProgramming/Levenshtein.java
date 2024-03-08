package algorithms.dynamicProgramming;

import java.util.Arrays;

public class Levenshtein {
    public static void main(String[] args) {
        String str1 = "Tuesday";
        String str2 = "Thursday";
        
        int m = str1.length();
        int n = str2.length();
        
        System.out.printf("recursive, the Levenshtein distance is - %d\n", getLDist(str1, str2, m, n));
        
        int[][] dp = new int[m][n];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        System.out.printf("Top to Bottom, the Levenshtein distance is - %d\n", getLDistTD(str1, str2, m, n, dp));
        
        System.out.printf("Bottom Up, the Levenshtein distance is - %d\n", getLDistBT(str1, str2));
    }
    
    // Bottom Up
    private static int getLDistBT(String str1, String str2) {
        int[][] lDist = new int[str1.length()+1][str2.length()+1];
        
        for (int i = 0; i<str1.length(); i++){
            lDist[0][i] = i;
        }
        for (int i = 0; i<str2.length(); i++){
            lDist[i][0] = i;
        }
        
        for (int i = 1; i<=str1.length(); i++){
            for (int j = 1; j<=str2.length(); j++){
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    lDist[i][j] = lDist[i-1][j-1];
                } else {
                    lDist[i][j] = Math.min(lDist[i][j-1], Math.min(lDist[i-1][j], lDist[i-1][j-1])) + 1;
                }
            }
        }
        return lDist[str1.length()][str2.length()];
    }
    
    // Bottom Up
    
    // Top to Bottom
    private static int getLDistTD(String str1, String str2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return Math.max(m, n);
        }
        
        if (dp[m-1][n-1]>=0){
            return dp[m-1][n-1];
        }
        
        // insertion
        int ch1 = 1 + getLDistTD(str1, str2, m, n - 1, dp);
        // deletion
        int ch2 = 1 + getLDistTD(str1, str2, m - 1, n, dp);
        
        // replacement
        int k = str1.charAt(m - 1) == str2.charAt(n - 1) ? 0 : 1;
        int ch3 = k + getLDistTD(str1, str2, m - 1, n - 1, dp);
        
        dp[m-1][n-1] = Math.min(ch1, Math.min(ch2, ch3));
        return dp[m-1][n-1];
    }
    
    
    // recursive
    private static int getLDist(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) {
            return Math.max(m, n);
        }
        
        // insertion
        int ch1 = 1 + getLDist(str1, str2, m, n - 1);
        // deletion
        int ch2 = 1 + getLDist(str1, str2, m - 1, n);
        
        // replacement
        int k = str1.charAt(m - 1) == str2.charAt(n - 1) ? 0 : 1;
        int ch3 = k + getLDist(str1, str2, m - 1, n - 1);
        
        return Math.min(ch1, Math.min(ch2, ch3));
    }
}
