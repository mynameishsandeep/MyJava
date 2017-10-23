package com.sample.tricky;

public class ProductOfNumbersExceptSelf {

	public int[] productExceptSelf(int[] arr) {
		int i, n = arr.length;
		int[] right = new int[n];
		int[] left = new int[n];

		right[0] = 1;
		for (i = 1; i < n; i++) {
			right[i] = right[i - 1] * arr[i - 1];
		}
		left[n - 1] = 1;
		for (i = n - 2; i >= 0; i--) {
			left[i] = left[i + 1] * arr[i + 1];
		}
		for (i = 0; i < n; i++) {
			right[i] = right[i] * left[i];
		}
		return right;
	}
}
