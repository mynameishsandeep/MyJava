package com.sample.tricky;

public class SquareRoot {

	static double square_root(double a, double epsilon) {

		//exception case
		if (Math.abs(a) < epsilon)
			return 0;

		double x = 1.5;

		while (true) {
			if (Math.abs(x * x - a) < epsilon)
				return x;
			double y = a / x;
			x = (x + y) / 2;
		}

	}

	public static int floorSqrt(int x) {
		// Base Cases
		if (x == 0 || x == 1)
			return x;

		// Do Binary Search for floor(sqrt(x))
		int start = 1, end = x, ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			// If x is a perfect square
			if (mid * mid == x)
				return mid;

			// Since we need floor, we update answer when mid*mid is
			// smaller than x, and move closer to sqrt(x)
			if (mid * mid < x) {
				start = mid + 1;
				ans = mid;
			} else // If mid*mid is greater than x
				end = mid - 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(square_root(.09, .000001));
		System.out.println(floorSqrt(11));
	}

}