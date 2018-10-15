package com.sample.basics;

import java.util.Random;

public class RandomGenerator {
	public void generate() {
		
		for (int i = 1; i < 2; i++) {
			// Below is not recommended, because System runs so faster and timestamp stays/
			// Ex: 11AM%1, 11AM%2, 11AM%3... So many time staying. 
			// if we need to give opportunity (probability) to choose all/any element, then this approach not recommended. 
			// Ex: https://leetcode.com/problems/linked-list-random-node/discuss/179672/Just-Funny.-Change-the-%22(System.currentTimeMillis()-(i-+-1)-i)%22-:)
			System.out.println(System.currentTimeMillis() % (i + 1));
		}
		System.out.println("======");
		
		Random r = new Random();
		for (int i = 1; i < 2; i++) {
			System.out.println(r.nextInt(i+1));
		}
	}

	public static void main(String[] args) {
		RandomGenerator test = new RandomGenerator();
		test.generate();
		Random r = new Random();
		System.out.println("======");
		System.out.println(r.nextInt(2));

	}
}