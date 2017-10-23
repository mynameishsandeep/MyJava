package com.sample.datastructure.recursion;

/**
 * 
 * Given a non-negative int n, compute recursively (no loops) the count of the
 * occurrences of 8 as a digit, except that an 8 with another 8 immediately to
 * its left counts double, so 8818 yields 4. Note that mod (%) by 10 yields the
 * rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost
 * digit (126 / 10 is 12).
 * 
 * http://codingbat.com/prob/p192383
 * 
 * @author chandrasekhar
 *
 */
public class Count8 {

	public static void main(String[] args) {
		System.out.println(new Count8().count8(88888));
	}

	public int count8(int n) {
		if (n < 10) {
			if (n == 8) {
				return 1;
			} else {
				return 0;
			}
		}
		if (n % 10 == 8 && (n / 10) % 10 == 8) {
			return count8(n / 10) + 2;
		}
		return count8(n / 10) + (n % 10 == 8 ? 1 : 0);
	}
}
