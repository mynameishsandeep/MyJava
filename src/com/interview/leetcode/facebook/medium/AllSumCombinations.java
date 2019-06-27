package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.List;

/*

current_sum: 0, start: 1, output: [ ]
current_sum: 1, start: 1, output: [ 1 ]
current_sum: 2, start: 1, output: [ 1,1 ]
current_sum: 3, start: 1, output: [ 1,1,1 ]
current_sum: 4, start: 1, output: [ 1,1,1,1 ]
Output: 1, 1, 1, 1

similar to FactorCombinations recursion
 */
public class AllSumCombinations {

	static void print_list(List<Integer> v) {
		for (int i : v) {
			System.out.print(i + ",");
		}
		System.out.println("");
	}

	static void print_all_sum_rec(int target, int current_sum, int start, List<Integer> output) {

		if (target == current_sum) {
			print_list(output);
		}

		for (int i = start; i < target; ++i) {
			int temp_sum = current_sum + i;
			if (temp_sum <= target) {
				output.add(i);
				print_all_sum_rec(target, temp_sum, i, output);
				output.remove(output.size() - 1);
			} else {
				return;
			}
		}
	}

	static void print_all_sum(int target) {
		List<Integer> output = new ArrayList<Integer>();
		print_all_sum_rec(target, 0, 1, output);
	}

	public static void main(String[] args) {
		int n = 4;
		print_all_sum(n);
	}
}