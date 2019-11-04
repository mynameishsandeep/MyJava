package com.sample.basics;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/count-primes/description/
 *
 * Prime Numbers are : 2, 3, 5, 7, 11, 13, 17, 19, 23 and 29.
 *
 * Note: n determines from 0.
 * So for n=2... Consider input as 0,1 which returns output as 0
 * So for n=3... Consider input as 0,1,2 which returns output as 1
 *
 * https://www.youtube.com/watch?v=I6HrVRGGYNI
 */
public class PrintPrimeNumbers {

  public static void main(String[] args) {
    Integer n = 50;
    PrintPrimeNumbers p = new PrintPrimeNumbers();
    System.out.println("Count: " + p.countPrimes(n));
  }

  public int countPrimes(int n) {
    int sqrtN = ((int) Math.sqrt(Double.valueOf(n - 1)));
    Boolean result[] = new Boolean[n];
    Arrays.fill(result, true);
    // System.out.println("sqrtN : " +sqrtN);
    for (int i = 2; i <= sqrtN; i++) {
      if (result[i]) {
        // System.out.println(i);
        for (int j = i + i; j < n; ) {
          result[j] = false;
          j = j + i;
        }
      }
    }
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (result[i]) {
        System.out.println(i);
        count++;
      }
    }
    return count;
  }
}
