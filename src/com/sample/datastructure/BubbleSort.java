package com.sample.datastructure;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int a[] = { 5, 1, 12, -5, 16 };
		for (int i = a.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (a[j] > a[j + 1]) {
					a[j] = a[j] ^ a[j + 1];
					a[j + 1] = a[j] ^ a[j + 1];
					a[j] = a[j] ^ a[j + 1];
				}
			}
			Arrays.stream(a).forEach(System.out::print);
			System.out.println("");
		}

	}
}
