package com.interview.leetcode.google.medium;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/hand-of-straights/description/
 * 
 * Alice has a hand of cards, given as an array of integers.
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * Return true if and only if she can.
 * 
 * 0) Sort the numbers.
 * 1) Check if group can be formed by mod operation.
 * 2) maxGroup can be formed is hand.length/straightGroupSize
 * 3) create an isVisited an array of size hand.length.
 * 4) Ex: 1 to 15 with groupSize 5... MaxGroup formed is 3.
 * 5) Outer Loop: Iterate entire hands of number. If a number is not visited. Change it to visited. 
 * Take that number as "start of straight number" or "prevNumber". 
 * Ex: for [1 2 3 4]  with group 2. 
 * 1 is the start of straight number in the first iteration.
 * 3 is the start of straight number in the second iteration.
 * 6) Inner Loop: Iterate by taking start of number and loop upto straightGroupSize.
 * 	  a) If prevNumber+1 == currentNumber. Then it is forming straight.
 * 	  b) If prevNumber+1 < currentNumber. Then cannot form straight. Return False.
 * 	  c) If prevNumber == currentNumber. Skip it.
 * 7) Update maxGroup. 
 * 8) If maxGroup reached and still isVisited is false for some numbers. Then return false.
 * 	  Ex: [1,2,2]: groupSize 3. index2 will be unVisited.
 * 	  Else, continue step5.
 * 	 
 * 
 */
public class HandOfStraights {

	public boolean isNStraightHand(int[] hand, int straightGroupSize) {
		if (hand.length % straightGroupSize != 0) {
			return false;
		}
		Arrays.sort(hand);
		boolean[] isVisited = new boolean[hand.length];
		int prevNumber = 0;
		int maxGroup = hand.length / straightGroupSize;
		for (int i = 0; i < hand.length; i++) {
			if (!isVisited[i]) {
				prevNumber = hand[i];
				isVisited[i] = true;
			} else {
				continue;
			}
			int tempstraightGroupSize = straightGroupSize - 1; // Take a number to compare against next number
			for (int j = i + 1; tempstraightGroupSize != 0 && j < hand.length; j++) {
				if (!isVisited[j]) {
					if (hand[j] == prevNumber + 1) {
						tempstraightGroupSize--;
						prevNumber = prevNumber + 1;
						isVisited[j] = true;
					} else if (hand[j] > prevNumber + 1) {
						return false;
					} else if (hand[j] == prevNumber) {
						// Equal Number, Ignore. might be used in next pair
					}
				}
			}
			if (--maxGroup == 0) {
				for (boolean visited : isVisited) {
					if (!visited) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		HandOfStraights h = new HandOfStraights();
		System.out.println(h.isNStraightHand(new int[] { 1, 1, 2, 2, 3, 3 }, 2)); // false
		System.out.println(h.isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3)); // true

	}

}
