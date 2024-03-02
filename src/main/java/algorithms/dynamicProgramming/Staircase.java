package algorithms.dynamicProgramming;

import java.util.Arrays;

public class Staircase {
    public static void main(String[] args) {
        int n=4;
        int k=3; // 1,2,3 steps
        int[] arr = new int[n+1];
        
        Arrays.fill(arr, -1);
        
        int waysTB = getWaysTopToBottom(n,k, arr);
        System.out.printf("Top to Down. The number of ways is: %d\n", waysTB);
        
        int waysBT = getWaysBottomToTop(n,k);
        System.out.printf("Bottom Up. The number of ways is: %d\n", waysBT);
        
    }
    // Bottom Up
    private static int getWaysBottomToTop(int n, int k) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        
        for (int i =1; i <= n; i++){
            arr[i] = 0;
            
            for (int j =0; j <= k; j++){
                if (i-j >=0) {
                    arr[i] = arr[i] + arr[i - j];
                }
            }
        }
        
        return arr[n];
    }
    
    // Top to Down
    private static int getWaysTopToBottom(int n, int k, int[] arr) {
        if (n==0){
            arr[n] = 1;
            return 1;
        }
        
        if (n<0){
            return 0;
        }
        
        if (arr[n] != -1){
            return arr[n];
        }
        
        arr[n] = 0;
        for (int i = 1; i <= k; i++){
            arr[n] =  arr[n] + getWaysTopToBottom(n-i, k, arr);
        }
        return arr[n];
    }
}
