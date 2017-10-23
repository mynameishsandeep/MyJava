package com.sample.datastructure.recursion;

/*
bunnyEars(0) → 0
bunnyEars(1) → 2
bunnyEars(2) → 4
 */
public class Plus2 {
	public static void main(String[] args) {
		System.out.println(bunnyEars(0));
	}

	public static int bunnyEars(int bunnies) {
		if (bunnies == 0) {
			return 0;
		}
		return bunnyEars(bunnies - 1) + 2;

	}

}
