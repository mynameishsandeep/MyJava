package com.yahoo.maths;

/*
* ==== GCD of n number can be obtained by gcd of 2 numbers transitively ===
* Ex :
* for 10,15,30.
* iteration 1 : Do GCD for 10,15. Result is 5
* Whatever the result we get, take that result and do it with next number.
* iteration 1 : Do GCD for 5,30.
* ==================
* =====GCD of 2 numbers can be obtained by mod operator=========
* Don't think of dividing number from 2 to n/2.
* Mod with recursion is the right answer.
  Ex: 15, 10
  a: 15 b: 10 =====>Iteration1
      \_
        \_
  (10%15) \
  a: 10 b: 15 =====>Iteration2
      \_
        \_
  (15%10) \
  a: 5 b: 10  =====>Iteration3
      \_
        \_
   (10%5) \
   a: 0 b: 5  =====>Iteration4
* Ex: 10, 15
* a: 10 b: 15
  a: 5 b: 10
  a: 0 b: 5
*
*/
public class GCD_Maths {
  // Function to return gcd of a and b
  static int gcd(int a, int b) {
    if (a == 0) return b;
    return gcd(b % a, a);
  }

  // Function to find gcd of array of numbers
  static int findGCD(int arr[], int n) {
    int result = arr[0];
    for (int i = 1; i < n; i++) {
      result = gcd(result, arr[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    int arr[] = {15, 10, 30};
    // int arr[] = { 4,10 };
    int n = arr.length;
    System.out.println(findGCD(arr, n));
  }
}
