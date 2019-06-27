package com.interview.leetcode.amazon.easy;

/*
 * 

Solution 1: Bit count

	Very intuitive. If n is the power of 2, the bit count of n is 1.
	Ex: 1(1), 2(10), 4(100), 8(1000)
	return n > 0 && Integer.bitCount(n) == 1;

Solution 2: Bit operation
	Ex: 1&2 =0, 3&4=0, 7&8=0
	return n > 0 && ((n & (n-1)) == 0);
	
Solution3: Divide by 2 till 1 comes
 */
public class PowerOfTwo {

  public boolean isPowerOfTwo(int n) {
    if (n == 0) {
      return false;
    }
    while (n % 2 == 0) {
      n = n / 2;
    }
    return n == 1;
  }
  
  
}
