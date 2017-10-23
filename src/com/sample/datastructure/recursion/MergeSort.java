package com.sample.datastructure.recursion;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 6, 1, 8, 5, 7 };
		System.out.println(Arrays.toString(arr));
		mergeSort(arr);
	}

	public static int[] mergeSort(int a[]) {
		int n = a.length;
		if (n == 1) {
			return a;
		}
		int mid = n / 2;
		
		// Copy left side data
		int left[] = new int[mid];
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		// Copy right side data
		int right[] = new int[n - mid];
		for (int i = 0, j = mid; i < right.length; i++, j++) {
			right[i] = a[j];
		}

		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);
		return a;
	}

	public static int[] merge(int left[], int right[], int result[]) {
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
		System.out.println(Arrays.toString(result));
		return result;
	}


}
