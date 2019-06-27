package com.interview.leetcode.facebook.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/4sum/description/
 * 
 * Ex: 1 2 3 4 5 6 7 8 9 --- Target 20..
 * 
1 2 3 9
1 2 4 9
1 2 5 9
1 2 6 9
1 2 7 9
1 2 8 9 -----Found
1 3 4 9
1 3 5 9
1 3 6 9
1 3 7 9 -----Found
1 4 5 9
1 4 6 9 -----Found
1 4 7 8 -----Found
1 5 6 9
1 5 6 8 -----Found
1 6 7 9
1 6 7 8
1 7 8 9
2 3 4 9
2 3 5 9
2 3 6 9 -----Found
2 3 7 8 -----Found
2 4 5 9 -----Found
2 4 6 8 -----Found
2 5 6 9
2 5 6 8
2 5 6 7 -----Found
2 6 7 9
2 6 7 8
2 7 8 9
3 4 5 9
3 4 5 8 -----Found
3 4 6 7 -----Found
3 5 6 9
3 5 6 8
3 5 6 7
3 6 7 9
3 6 7 8
3 7 8 9
4 5 6 9
4 5 6 8
4 5 6 7
4 6 7 9
4 6 7 8
4 7 8 9
5 6 7 9
5 6 7 8
5 7 8 9
6 7 8 9

 * 
 * 
 * O(n^3)
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 3; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1]))
				for (int j = i + 1; j < num.length - 2; j++) {
					if (j == i + 1 || num[j] != num[j - 1]) {
						int left = j + 1, right = num.length - 1, sum = target - num[i] - num[j];
						while (left < right) {
							System.out.print(num[i] + " ");
							System.out.print(num[j] + " ");
							System.out.print(num[left] + " " + num[right]);
							if (num[left] + num[right] == sum) {
								res.add(Arrays.asList(num[i], num[j], num[left], num[right]));
								while (left < right && num[left] == num[left + 1])
									left++;
								while (left < right && num[right] == num[right - 1])
									right--;
								left++;
								right--;
							} else if (num[left] + num[right] < sum)
								left++;
							else
								right--;
							System.out.println("");
						}
					}
				}
		}
		return res;
	}

	public static void main(String[] args) {
		FourSum f = new FourSum();
		System.out.println(f.fourSum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 20));
	}
}
