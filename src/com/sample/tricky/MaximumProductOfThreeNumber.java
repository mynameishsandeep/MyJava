package com.sample.tricky;

/*
 * Key here is if the input is negative number. Then result will vary
 * Ex: -5,-4,0,1,2.....Output is 40. (-5*-4=20*2=40). 
 * So ideal solution without sorting would be.

 * 1) Keep 3 max variable, 2 minimum variable(-5 is minimum than -4). Because (-5) * (-4) = +20.
 * 2) Get the max of 3 max or 1st max and 2 min 
 * 
 */
public class MaximumProductOfThreeNumber {

	public static int maximumProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE,
				min2 = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (n > max2) {
				max3 = max2;
				max2 = n;
			} else if (n > max3) {
				max3 = n;
			}

			if (n < min1) {
				min2 = min1;
				min1 = n;
			} else if (n < min2) {
				min2 = n;
			}
		}
		return Math.max(max1 * max2 * max3, max1 * min1 * min2);
	}

	public static void main(String[] args) {
		int input[] = { -1, -2, -3, -4 };
		System.out.println(maximumProduct(input));
	}
}
