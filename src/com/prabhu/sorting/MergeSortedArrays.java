package com.prabhu.sorting;

import java.util.Arrays;

/**
 * This is the merge logic present in merge sort
 */
public class MergeSortedArrays {

	public static void main(String[] args) {
		int a[] = { 2, 4, 6, 8 };
		int b[] = { 1, 3, 5, 7, 9, 11 };
		System.out.println(Arrays.toString(merge(a, b)));

	}

	public static int[] merge(int left[], int right[]) {
		int result[] = new int[left.length + right.length];
		int i, j, k = 0;
		for (i = 0, j = 0, k = 0; i < result.length; i++) {
			if (j == left.length) {
				result[i] = right[k];
				k++;
			} else if (k == right.length) {
				result[i] = left[j];
				j++;
			} else if (left[j] < right[k]) {
				result[i] = left[j];
				j++;
			} else {
				result[i] = right[k];
				k++;
			}
		}
		return result;
	}

}
