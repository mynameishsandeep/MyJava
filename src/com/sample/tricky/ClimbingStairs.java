package com.sample.tricky;

/*
* https://leetcode.com/problems/climbing-stairs/description/
*
* https://www.geeksforgeeks.org/count-ways-reach-nth-stair/

* You are climbing a stair case. It takes n steps to reach to the top.
* Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*
* On analyzing the result, solution is based on Fibonacci Series

   * Example: if number of step is 3. I can code below.
   * f(n) = f{ (n-1) + (n-2) + (n-3) }
   *
   * But to generalize to any steps. for loop is best approach.
   */

public class ClimbingStairs {

  public int climbStairs(int n) {
    int[] dp = new int[n + 1];
    return fib(n, dp);
  }

  public int fib(int n, int[] dp) {
    if (n < 2) return n;
    if (dp[n] == 0) dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    return dp[n];
  }
}
