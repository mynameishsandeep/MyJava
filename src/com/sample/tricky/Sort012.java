package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This problems can be asked like sort 123 or sort 012 or any combo...
 * This is also DutchFlag Problem
 *
 */
public class Sort012 {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1, 3, 2, 1, 2, 3));
		Integer low = 0;
		Integer high = input.size() - 1;
		Integer mid = 0;
		while (mid < high) {
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
