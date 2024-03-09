package algorithms.dynamicProgramming;

public class RodCutting {
    public static void main(String[] args) {
        int[] price = new int[] {4,5,8,9};
        int size = price.length;
        
        System.out.printf("Recursive, Rod Cut - %d\n", rodCut(price,size));
        
        int[] dp = new int[size];
        System.out.printf("Top to Bottom, Rod Cut - %d\n", rodCutTD(price,size, dp));
        
        System.out.printf("Bottom Up, Rod Cut - %d\n", rodCutBT(price));
    }
    
    // Bottom Up
    private static int rodCutBT(int[] price) {
        int[] r = new int[price.length+1];
        r[0]= 0;
        
        int maxRevenue = Integer.MIN_VALUE;
        
        for (int i = 1; i<r.length; i++){
            for (int j = 1; j<=i; j++){
                maxRevenue=Math.max(maxRevenue, price[j-1]+r[i-j]);
            }
            r[i]= maxRevenue;
        }
        return r[price.length];
    }
    
    // Top to Bottom
    private static int rodCutTD(int[] price, int size, int[] dp) {
        if (size == 0){
            return 0;
        }
        
        if (dp[size-1]>0){
            return dp[size-1];
        }
        int maxRevenue = Integer.MIN_VALUE;
        
        for (int i=1; i<=size; i++){
            maxRevenue = Math.max(maxRevenue, price[i-1] + rodCut(price,size-i));
        }
        
        return dp[size-1] = maxRevenue;
    
    }
    
    // Recursive
    private static int rodCut(int[] price, int size) {
        if (size == 0){
            return 0;
        }
        
        int maxRevenue = Integer.MIN_VALUE;
        
        for (int i=1; i<=size; i++){
            maxRevenue = Math.max(maxRevenue, price[i-1] + rodCut(price,size-i));
        }
        
        return maxRevenue;
    }
}
