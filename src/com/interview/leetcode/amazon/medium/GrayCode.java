package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/gray-code/discuss/140164/java-beats-100-with-comments
 * Binary to Gray-Code : https://www.youtube.com/watch?v=IeWcvAsz88o
 *
 * 1) Add a constant to the previous result, from the last.
 * 2) The constant is 1,2,4,8 -->left shift operation 
 * 
The key is to find the pattern.
n=0: 0
n=1, k=1: 0, 0+1=1 (Adding 1 to 0)
n=2, k=2: 0, 1, 1+2, 0+2 (Adding 2 to 1,0)
n=3, k=4: 0, 1, 3, 2, 2+4, 3+4, 1+4, 0+4 (Adding 4 to 2,3,1,0)
 */
public class GrayCode {

	public static void main(String[] args) {
		GrayCode g = new GrayCode();
		System.out.println(g.grayCode(4));
	}

	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		result.add(0);
		for (int i = 1; i <= n; i++) {
			int k = 1 << (i - 1);// leftShift to get the constant k
			System.out.println(" Constant k " + k);
			for (int j = result.size() - 1; j >= 0; j--) {
				int prevResultFromLast = result.get(j);
				System.out.println(" prevResult From Last " + prevResultFromLast);
				result.add(prevResultFromLast + k);
			}
		}
		return result;
	}
}
