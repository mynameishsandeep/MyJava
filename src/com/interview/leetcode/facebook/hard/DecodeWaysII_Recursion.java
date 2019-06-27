package com.interview.leetcode.facebook.hard;

/*
 *  3* --> 9 
 *  1* --> 18 [1 1, 1 2, 1 3, 1 4, 1 5, 1 6, 1 7, 1 8, 1 9, 11, 12, 13, 14, 15, 16, 17,18, 19]
 *  *1 --> 11 [1 1, 2 1, 3 1, 4 1, 5 1, 6 1, 7 1, 8 1, 9 1, 11, 21]
 *  *7 --> 10 [1 7, 2 7, 3 7, 4 7, 5 7, 6 7, 7 7, 8 7, 9 7, 17]
 *  ** --> 96
 */
public class DecodeWaysII_Recursion {

	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		long fN = 0;
		long fNMinus1 = (s.charAt(0) == '*') ? 9 : 1;
		long fNMinus2 = 1;
		for (int i = 1; i < s.length(); i++) { // Just think of input 10
			char first = s.charAt(i - 1);
			char second = s.charAt(i);
			if (second == '0') {
				// if 0 do nothing
			} else if (second == '*') {
				fN += 9 * fNMinus1;
			} else { // Look for 1 to 9. copy previous
				fN = fNMinus1;//f(n) = f(n-1);
			}

			if (first == '*') {
				if (second == '*') {
					fN += 15 * fNMinus2;
				} else if (second <= '6') { // Because number ends with 26
					fN += 2 * fNMinus2;
				} else {
					fN += fNMinus2;
				}
			} else if (first == '1' || first == '2') {
				if (second == '*') {
					if (first == '1') {
						fN += 9 * fNMinus2;
					} else { // first == '2'
						fN += 6 * fNMinus2;
					}
				} else {
					int twoDigit = Integer.valueOf(s.substring(i - 1, i + 1));
					if (twoDigit >= 10 && twoDigit <= 26) {
						fN += fNMinus2; // if >=10 && <= 26. add current and previous.previous
					}
				}

			}

			fNMinus2 = fNMinus1;
			fNMinus1 = fN % 1000000007;
			fN = 0;
		}
		return (int) fNMinus1;

	}

	public static void main(String[] args) {
		DecodeWaysII_Recursion d = new DecodeWaysII_Recursion();
		//System.out.println(d.numDecodings("1234")); // [1234] [12,3,4][1,23,4]
		//System.out.println(d.numDecodings("1**")); //177
		//System.out.println(d.numDecodings("3*")); //
		//		System.out.println(d.numDecodings("**")); //
		//	System.out.println(d.numDecodings("**1")); //
		//System.out.println(d.numDecodings("**********1111111111"));
		System.out.println(d.numDecodings("*1"));
		System.out.println(d.numDecodings("*2"));

	}
}
