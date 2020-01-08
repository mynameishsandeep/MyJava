package com.sample.tricky;

/*
* https://www.geeksforgeeks.org/n-bonacci-numbers/
*
* https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/YQy7Lx79R0K
* Also Refer problem ClimbingStairs
*   So inside the for loop. i value is passed (like n-i instead of n-1) result is accumulated.
* Note: loop should start from 1 and ends till <=n
*
* n=3
0 1 2 3 4 5
0 1 1 2 4 7


*/
public class Fibonacci_Nbonacci {

  public int fibXSteps(int n, int numberOfSteps) {
    if (n < 2) return n;
    int result = 0;
    for (int i = 1; i <= numberOfSteps; i++) {
      int currentResult = fibXSteps(n - i, numberOfSteps);
      result += currentResult;
    }
    return result;
  }
}
