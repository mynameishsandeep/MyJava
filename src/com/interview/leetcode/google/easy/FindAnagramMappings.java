package com.interview.leetcode.google.easy;

import java.util.HashMap;
import java.util.Map;

/**
	https://leetcode.com/problems/find-anagram-mappings/description/
	
	A = [12, 28, 46, 32, 50]
	B = [50, 12, 32, 46, 28]
	We should return
	[1, 4, 3, 2, 0]

 *
 */
public class FindAnagramMappings {
	public int[] anagramMappings(int[] A, int[] B) {
		int[] result = new int[A.length];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			map.put(B[i], i);
		}
		for (int i = 0; i < A.length; i++) {
			result[i] = map.get(A[i]);
		}
		return result;
	}
}
