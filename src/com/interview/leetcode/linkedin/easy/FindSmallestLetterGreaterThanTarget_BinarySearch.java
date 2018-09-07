package com.interview.leetcode.linkedin.easy;

/*
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 * 
 * 1) If the input doesn't contains duplicate. Then first(==) if condition can directly return "mid+1".
 * 2) For duplicate we have to find the rightmost so going (midIndex + 1, highIndex) logic.
 */
public class FindSmallestLetterGreaterThanTarget_BinarySearch {
	public char nextGreatestLetter(char[] letters, char target) {
		int index = binarySearch(letters, target, 0, letters.length - 1);
		if (index > letters.length - 1) {
			return letters[0];
		}
		return letters[index];
	}

	public int binarySearch(char[] letters, char target, int lowIndex, int highIndex) {
		if (lowIndex <= highIndex) {
			int midIndex = (lowIndex + highIndex) / 2;
			// We can take off the if condition, meaning it will go to else logic which is same as if logic 
			if (letters[midIndex] == target) {
				return binarySearch(letters, target, midIndex + 1, highIndex);
			} else if (letters[midIndex] > target) {
				return binarySearch(letters, target, lowIndex, midIndex - 1);
			} else {
				return binarySearch(letters, target, midIndex + 1, highIndex);
			}
		}
		return lowIndex;
	}

	public static void main(String[] args) {
		char c[] = { 'c', 'f', 'j' };
		FindSmallestLetterGreaterThanTarget_BinarySearch f = new FindSmallestLetterGreaterThanTarget_BinarySearch();
		System.out.println(f.nextGreatestLetter(c, 'k'));

	}
}
