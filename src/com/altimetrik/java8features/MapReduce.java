package com.altimetrik.java8features;

import java.util.Arrays;

/**
 * Calculate the sum of square of given number
 *
 */
public class MapReduce {

	public static void main(String[] args) {
		// 1 + 16 + 4 = 21
		Integer[] a = {1,4,2};
		System.out.println(Arrays.stream(a).mapToInt(Integer::intValue).map((i)->i*i).sum());

	}

}
