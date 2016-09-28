package com.sample.tricky;

public class FindMovingAverage {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		int n = 2;
		int sum = 0;
		for (int i = 1; i < a.length; i++) {
			sum -= a[i % n];
			a[i % n] = a[i];
			sum += a[i % n];
			if (i >= n)
				System.out.println(sum / n + " ");
		}
	}

}
