package com.sample.datastructure;

import java.util.HashMap;
import java.util.Map;

/** f(n) = { f(n-1) + f(n-2) } */
public class Fibonacci {
  static Map<Integer, Integer> cache = new HashMap<>();

  public static void main(String[] args) {

    int n = 6;
    System.out.println(fibRecursive(n));
    System.out.println(fibWhile(n));
    System.out.println(fibMemoization(n));
  }

  // Time Complexity is O(2^n)
  public static int fibRecursive(int n) {
    if (n <= 1) { // Exit Condition
      return n;
    } else {
      // Recursive case
      return (fibRecursive(n - 1) + fibRecursive(n - 2));
    }
  }

  // Time Complexity is O(n)
  private static int fibMemoization(int n) {
    if (n <= 1) {
      return n;
    }
    if (cache.containsKey(n)) {
      return cache.get(n);
    } else {
      Integer result = fibMemoization(n - 1) + fibMemoization(n - 2);
      cache.put(n, result);
      // System.out.println(result);
      return result;
    }
  }

  /*
   * f(n) = fNMinus2+fNMinus1;
   */
  public static int fibWhile(int n) {
    if (n <= 1) {
      return n;
    }
    int fNMinus2 = 0;
    int fNMinus1 = 1;
    int fN = 1;
    for (int i = 2; i <= n; i++) {
      fN = fNMinus2 + fNMinus1;
      fNMinus2 = fNMinus1;
      fNMinus1 = fN;
    }
    return fN;
  }

  public int CalculateFibonacci(int n) {
    int dp[] = new int[n + 1];

    // base cases
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }
}
