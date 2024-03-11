package algorithms.dynamicProgramming;

import java.util.Arrays;

public class MatrixChain {
    public static void main(String[] args) {
        int[] seq = new int[] {4,3,2,1,5};
        int n = seq.length;

        System.out.printf("Recursive, Matrix Chain, MIN number of multiplications - %d\n", mcm(seq, 1, n-1));
        
        int[][] arr = new int[n][n];
        Arrays.stream(arr).forEach(row -> Arrays.fill(row, -1));
        System.out.printf("Top to Bottom, Matrix Chain, MIN number of multiplications - %d\n", mcmTB(seq, 1, n-1, arr));
        
        System.out.printf("Bottom Up, Matrix Chain, MIN number of multiplications - %d\n", mcmBU(seq, n));
     }
    
     // Bottom Up
    private static int mcmBU(int[] seq, int n) {
        int[][] arr = new int[n][n];
        
        for (int i = 0; i<n; i++){
            arr[i][i]=0;
        }
        for (int len = 2; len<n; len++){
            for (int i =1; i<=n-len; i++){
                int j =i+len-1;
                if (j==n){
                    continue;
                }
                int minOps = Integer.MAX_VALUE;
                for (int k=i; k<j;k++){
                    minOps = Math.min(minOps, arr[i][k]+arr[k+1][j] + seq[i-1]*seq[k]*seq[j]);
                    arr[i][j] = minOps;
                }
            }
        }
        return arr[1][n-1];
    }
    
    // Top to Bottom
    private static int mcmTB(int[] seq, int i, int j, int[][] arr) {
        if (i==j){
            return arr[i][j]=0;
        }
        
        if (arr[i][j]>=0){
            return arr[i][j];
        }

        int minOps = Integer.MAX_VALUE;
        
        for (int k=i; k<j; k++){
            int ops = mcmTB(seq, i,k, arr) + mcmTB(seq, k+1, j, arr) + seq[i-1]*seq[k]*seq[j];
            minOps = Math.min(minOps, ops);
        }
        return arr[i][j]=minOps;
    }

    
    // Recursive
    private static int mcm(int[] seq, int i, int j) {
        if (i==j){
            return 0;
        }
        
        int minOps = Integer.MAX_VALUE;
        
        for (int k=i; k<j; k++){
            int ops = mcm(seq, i,k) + mcm(seq, k+1, j) + seq[i-1]*seq[k]*seq[j];
            minOps = Math.min(minOps, ops);
        }
        return minOps;
    }
}
