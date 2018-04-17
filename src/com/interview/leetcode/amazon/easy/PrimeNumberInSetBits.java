package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
 */
public class PrimeNumberInSetBits {

	public static void main(String[] args) {
		PrimeNumberInSetBits p = new PrimeNumberInSetBits();
		System.out.println(p.countPrimeSetBits(10, 16));
	}
	public int countPrimeSetBits(int L, int R) {
		int result = 0;
		for (int i = L; i <= R; i++) {
			if (isPrime(Integer.bitCount(i))) {
				result++;
			}
		}
		return result;
	}

	private boolean isPrime(Integer data) {
		if (data == 2 || data == 3 || data == 0) {
			return true;
		}
		if (data == 1) {
			return false;
		}
		for (int i = 2; i <= data / 2; i++) {
			if (data % i == 0) {
				return false;
			}
		}
		return true;
	}
}
