package com.sample.datastructure;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int a[] = { 5, 1, 12, -5, 16 };
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		Arrays.stream(a).forEach(System.out::println);
	}
}
