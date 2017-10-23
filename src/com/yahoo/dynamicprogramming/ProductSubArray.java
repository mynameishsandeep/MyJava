package com.yahoo.dynamicprogramming;

public class ProductSubArray {

	public static void main(String args[]){
        int[] arr = {2,3,6};
        int k = 10;
        int n = productSubArrCount(arr, k);
        System.out.println(n);
    }
   
   public static int productSubArrCount(int[] arr, int k){
    
        int n = arr.length;
        int[][] dp = new int[k+1][n+1];
        
        for(int i = 1; i <= k; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i][j-1];
                if(i >= arr[j-1] && arr[j-1] > 0 && i/arr[j-1] < (k+1))    
                    dp[i][j] += dp[i/arr[j-1]][j-1]+1;
            }
        }
        return dp[k][n];
    }
}
