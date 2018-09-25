package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Solution1: Worst Approach.
 * Count the number of 0’s, 1’s and 2’s. After Counting, put all 0’s first, then 1’s and lastly 2’s in the array. 
 * We traverse the array two times.
 * 
 * Solution2:
 * 1) Keep 3 pointers. low (represents 0), mid (represents 1), high (represents 2). 
 * 2) Keep low and mid at 0; high at n-1.
 * 3) if input is 0. Swap low and mid. increment low and mid. 
 * 4) if input is 1. increment mid.
 * 5) if input is 2. Swap mid and high. decrement high. 
 * 
 * Note: 
 * 1) In the for loop, Each element is compared against mid... not low... 
 * 2) Another key is mid<=high and not mid<high
 * 
 * This problems can be asked like sort 123 or sort 012 or arrange 3 colors in order or any combo...
 * This is also DutchFlag Problem
 *
 */
public class Sort012 {

	public static void main(String[] args) {
		//List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1, 3, 2, 1, 2, 3));
		List<Integer> input = new ArrayList<>(Arrays.asList(3,1,2));
		Integer low = 0;
		Integer high = input.size() - 1;
		Integer mid = 0;
		while (mid <= high) {
			Integer data = input.get(mid);
			switch (data) {
			case 1:
				Collections.swap(input, low++, mid++);
				break;
			case 2:
				mid++;
				break;
			case 3:
				Collections.swap(input, mid, high--);
				break;
			}
		}
		System.out.println(input);
	}
}
