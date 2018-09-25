package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * https://www.youtube.com/watch?v=vtJvbRlHqTA
 * 
This problem is one of mathematical approach to solve.
At any point in multiplication, there are 2 case 1) max product 2) min product.
1) Max Product will be maximum of "prevMaxProduct and current number" or "prevMinProduct and current number" or "current number itself"
This formula is arrived based on 3 cases
case 1:  "prevMaxProduct and current number" -> current Number is positive Number and previous Max Product is positive number
case 2:	 "prevMinProduct and current number" -> current Number is negative Number and previous Min Product is negative number
case 3:  "current number itself" -> current number is +number or 0 or -number. But still it is Max.  

2) Min Product will be minimum of "prevMaxProduct and current number" or "prevMinProduct and current number" or "current number itself"

============Wrong Approach========
Solving this problem by less than 0, equal to 0 and more than 0 with if condition, with multiple condition will keep fail. 
Confusion will arrive, to set 0 or 1 in maxProdut, minProduct etc... don't waste time
I spent more than 2 hours and was failing at various test cases and nothing succeeded fully.
=============


 */
public class MaximumProductSubarray {

	public int maxProduct(int nums[]) {
		int currMaxProduct = nums[0];
		int prevMaxProduct = nums[0];
		int maxProduct = nums[0];
		int minProduct = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int currentNumber = nums[i];
			currMaxProduct = Math.max(Math.max(prevMaxProduct * currentNumber, minProduct * currentNumber), currentNumber);
			minProduct = Math.min(Math.min(prevMaxProduct * currentNumber, minProduct * currentNumber), currentNumber);
			maxProduct = Math.max(maxProduct, currMaxProduct);
			prevMaxProduct = currMaxProduct;
		}
		return maxProduct;
	}
}
