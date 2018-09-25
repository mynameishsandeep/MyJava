package com.sample.tricky;

public class ProductOfNumbersExceptSelf {

	/*

1) Fill leftToRight index[0] as 1.
2) Multiply input at index 0 with leftToRight 0th index and put it in leftToRight index 1
3) Multiply input at index 1 with leftToRight 1st index and put it in leftToRight index 2
4) Go on till end-1 

5) Fill rightToLeft index[n-1] as 1.
6) Multiply input at index n-1 with rightToLeft n-1 index and put it in leftToRight index n
7) Multiply input at index n-2 with rightToLeft n-2 index and put it in leftToRight index n-1
8) Go on till 1 

9) Multiply leftToRight * rightToLeft

1	2	4	5
*   *	*	* 
1	1	2	8 ===> Result1 leftToRight... Fill 1 in first

=============
1	2	4	5
*   *	*	* 
40	20	5	1 ===> Result2 rightToLeft... Fill 1 in last

==============




	 */
	public int[] productExceptSelf(int[] arr) {
		int i, n = arr.length;
		int[] leftToRight = new int[n];
		int[] rightToLeft = new int[n];

		leftToRight[0] = 1;
		for (i = 1; i < n; i++) {
			leftToRight[i] = leftToRight[i - 1] * arr[i - 1];
		}
		rightToLeft[n - 1] = 1;
		for (i = n - 2; i >= 0; i--) {
			rightToLeft[i] = rightToLeft[i + 1] * arr[i + 1];
		}
		for (i = 0; i < n; i++) {
			leftToRight[i] = leftToRight[i] * rightToLeft[i];
		}
		return leftToRight;
	}
}
