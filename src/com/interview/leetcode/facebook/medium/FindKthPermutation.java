package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n) 
https://www.educative.io/collection/page/5642554087309312/5679846214598656/140001

A naive way of finding kth permutation will be to find all permutations and then return the kth permutation or 
maintain a running count of permutations seen so far and return once kth permutation is reached.

Below approach Runtime Complexity is O(n).
1) Identify the block where the result exists.
2) Remove that block and continue step1. till empty.

===How to identify Block==
1) block_size = (n-1)! ['n' is the size of input]
2) block = k-1/block_size;
3) k = k - selectedBlock*block_size
================
 * 
 * 123
 * 132
 * 213
 */
public class FindKthPermutation {
	public static void main(String[] args) {
		FindKthPermutation f = new FindKthPermutation();
		System.out.println(f.getPermutation(3, 3));
	}

	public String getPermutation(int n, int k) {
		List<Integer> numbers = new ArrayList<>();
		int[] factorial = new int[n + 1];
		StringBuilder sb = new StringBuilder();

		// create an array of factorial lookup
		int sum = 1;
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;
			factorial[i] = sum;
		}
		// factorial[] = {1, 1, 2, 6, 24, ... n!}

		// create a list of numbers to get indices
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		// numbers = {1, 2, 3, 4}

		k--;

		for (int i = 1; i <= n; i++) {
			int blockSize = factorial[n - i];
			int selectedBlock = k / blockSize;
			sb.append(String.valueOf(numbers.get(selectedBlock))); // Save the block to result.
			numbers.remove(selectedBlock); // Remove the block result from input
			k -= selectedBlock * blockSize; // Update k
		}

		return String.valueOf(sb);
	}

}
