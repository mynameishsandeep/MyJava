package com.interview.leetcode.google.medium;

/*
* https://leetcode.com/problems/divide-two-integers/description/
* https://www.educative.io/collection/page/5642554087309312/5679846214598656/180001
*=====Naive Approach=====
*We can count the number of times that the divisor can be added to approach the dividend.
*This solution is really inefficient. For example, we would end up doing ~50K iterations while calculating 100000÷2.
*=====
*
* 1) Keep increment the tempDivisor and quotient by twice, by left shift operation.
* 4) At anypoint, if tempDivisor>dividend. recurse again with newDividend and Divisor
*
==========================================
Ex: 40/4 = 10

Recursion1

Dividend  Divisor  Quotient  TempDivisor
40 			4 		 1		  4
40			4		 2		  8
40			4		 4		 16
40			4		 8		 32
40			4		16		 64

Go One Step Back
Dividend  Divisor  Quotient  TempDivisor
40 			4 		 8		 32

Recursion2
Dividend  Divisor  Quotient  TempDivisor
8			4
===============================
*
*
* 	  -2147483648  -1
  For the above input overflow. Using long is 1 solution

	-2147483648  1 -- Overflow will not occur for this one because it is max of negative
*/
public class DivideTwoIntegers {

  public int divide(int dividend, int divisor) {
    // Calculate sign of divisor i.e., sign will be negative only if either one of them is negative
    // otherwise it will be positive
    boolean isNeg = (dividend < 0) ^ (divisor < 0); // Logical XOR operation.
    // boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

    // use long to take care of overflow
    long longDividend = Math.abs((long) dividend); // remove negative by Math.abs
    long longDivisor = Math.abs((long) divisor);
    long result = divideRecur(longDividend, longDivisor);
    // Add/Remove Negative to the result.
    result = isNeg ? -result : result;

    return (int) (result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result);
  }

  public long divideRecur(long dividend, long divisor) {
    // We will return -1 if the divisor is '0'.
    if (divisor == 0) return -1;
    if (dividend == divisor) return 1;
    if (dividend < divisor) return 0;

    long tempDivisor = divisor;
    long quotient = 1;
    while (dividend > tempDivisor) {
      tempDivisor <<= 1;
      quotient <<= 1;
    }
    if (dividend == tempDivisor) return quotient; // result found
    tempDivisor >>= 1;
    quotient >>= 1;
    return quotient + divideRecur(dividend - tempDivisor, divisor);
  }

  public static void main(String[] args) {
    DivideTwoIntegers d = new DivideTwoIntegers();
    System.out.println(d.divide(40, 4));
  }
}
