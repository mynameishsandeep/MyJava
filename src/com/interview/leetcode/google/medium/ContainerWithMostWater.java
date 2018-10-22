package com.interview.leetcode.google.medium;

/*
 * https://leetcode.com/problems/container-with-most-water
 * 
 * 1) Keep left pointer which start from 0 and right pointer which start from n-1
 * 2) Get the "current Water hold" by the formula; 
 * 		minimum value of ("left", "right") * width(or how much it can hold. Based on index "right-left".)
 * 		Ex: [10,5,2] --> Min(10,2)*(2-0) --> 4
 * 3) Increment or Decrement width(left or right) based on minimum value. 		
 * 			a) Increment left side, if left side value is minimum.
 * 			b) Decrement right side, if right side value is minimum.
 * 			c) If left side value == right side. Then increment left side or decrement right side, anything will work.
 * 4) Do step 2 & 3 till left<right.
 *		  		Ex: [10,5,2] --> Min(10,2)*(2-0) --> 4
 *		  			[10,5,2] --> Min(10,5)*(1-0) --> 5
 * 5) Save the "current Water hold" value to maxWaterHold each time by comparing.
 * 6) return maxWaterHold  			
 * 
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int maxWaterHold = 0;
		while (left < right) {
			int currentMinimum = Math.min(height[left], height[right]);
			int currentWidth = right - left; // Ex: for [10,5,2]... 1st time width will be (2-0) = 2
			int currentWaterHold = currentMinimum * currentWidth;
			System.out.println("Current Water Hold: " + currentWaterHold);
			maxWaterHold = Math.max(maxWaterHold, currentWaterHold);
			if (height[left] < height[right]) {
				left++;
			} else if (height[left] > height[right]) {
				right--;
			} else { // can be skipped totally, Just for understanding keeping this line
				left++;// or right--; Both will work
			}
		}
		return maxWaterHold;
	}

	public static void main(String[] args) {
		ContainerWithMostWater c = new ContainerWithMostWater();
		//c.maxArea(new int[] { 10, 1 });
		System.out.println(c.maxArea(new int[] { 10, 5, 2 }));
	}
}
