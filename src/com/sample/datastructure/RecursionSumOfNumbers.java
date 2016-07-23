package com.sample.datastructure;

public class RecursionSumOfNumbers {

	public static void main(String[] args) {

		int a[] = { 10, 2, 3, 4, 5 };
		System.out.println(recurse(a, 4));

	}

	public static int recurse(int arr[], int n) {
		
		if(n == -1 ) {
			return 0;
		} else {
			return arr[n] + recurse(arr, n-1);
		}
	}

}
