package com.sample.basics;

import java.util.Arrays;

/**
 * Merge 2 sorted arrays without 3rd array. 1) Array1 size is n 2) Array2 size
 * is m+n.But there will be data only on m.Extra n would be empty. 3) Solution:
 * Move the Array2 element to end. Sort Array1 index0 with Array2 (index n+1)
 * 
 * @author sisuser
 *
 */
public class MergeArray {
	void merge(int arr1[], int arr2[], int n) {
		int i = n;
		for (int j = 0, k = 0; k < arr2.length - 1; k++) {
			if (arr1[j] >= arr2[i]) {
				arr2[k] = arr2[i];
				i++;
			} else {
				arr2[k] = arr1[j];
				j++;
			}
		}
	}

	public static void main(String[] args) {
		MergeArray mergearray = new MergeArray();
		int arr1[] = { 1, 3, 5 };
		int arr2[] = { -1, -1, -1, 2, 4, 6 };
		int n = arr1.length;

		mergearray.merge(arr1, arr2, n);
		mergearray.print(arr2);
	}

	void print(int arr[]) {
		Arrays.stream(arr).forEach(System.out::print);
	}

}
