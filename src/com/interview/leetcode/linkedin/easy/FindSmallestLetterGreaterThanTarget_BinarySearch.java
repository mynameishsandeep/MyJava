package com.interview.leetcode.linkedin.easy;

/*
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 *
 * 1) if target matches a letter, then we have to move right. 
 * 2) low goes beyond index for the below sample. So mod the result. 
		letters = ["c", "f", "j"]
		target = "j"
		Output: "c"
 */
public class FindSmallestLetterGreaterThanTarget_BinarySearch {
  public char nextGreatestLetter(char[] letters, char target) {
    int index = binarySearch(letters, target, 0, letters.length - 1);
    return letters[index % letters.length];
  }

  public int binarySearch(char[] letters, char target, int low, int high) {
    if (low <= high) {
      int mid = (low + high) / 2;
      if (letters[mid] == target) {
        return binarySearch(letters, target, mid + 1, high);
      } else if (letters[mid] > target) {
        return binarySearch(letters, target, low, mid - 1);
      } else {
        return binarySearch(letters, target, mid + 1, high);
      }
    }
    return low;
  }

  public static void main(String[] args) {
    char c[] = {'c', 'f', 'j'};
    FindSmallestLetterGreaterThanTarget_BinarySearch f =
        new FindSmallestLetterGreaterThanTarget_BinarySearch();
    System.out.println(f.nextGreatestLetter(c, 'k'));
  }
}
