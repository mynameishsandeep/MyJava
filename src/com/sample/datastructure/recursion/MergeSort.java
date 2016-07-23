package com.sample.datastructure.recursion;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 4, 2, 6, 1, 8, 5, 7, 3 };
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(mergeSort(arr)));
	}

	public static int[] mergeSort(int a[]) {
		int n = a.length;
		if (n == 1) {
			return a;
		}
		int mid = n / 2;
		int left[] = new int[mid];
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}

		int right[] = new int[n - mid];
		for (int i = 0, j = mid; i < right.length; i++, j++) {
			right[i] = a[j];
		}

		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);
		return a;
	}

	public static int[] merge(int left[], int right[], int arr[]) {
		int n = left.length + right.length;
		for (int i = 0, j = 0, k = 0; i < n; k++) {
			if (left[i] > right[j]) {
				arr[k] = right[j];
				j++;
			} else {
				arr[k] = left[i];
				i++;
			}

			if (i == left.length) {
				for (int x = ++k; x < arr.length; x++, k++,j++) {
					arr[x] = right[j];
				}
				break;
			}
			if (j == right.length) {
				for (int x = ++k; x < arr.length; x++, k++,i++) {
					arr[x] = left[i];
				}
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}

}
