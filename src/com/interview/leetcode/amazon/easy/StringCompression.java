package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/string-compression/
 * 0) Key to the solution is keeping 3 variables "resultIndex", "left" and "right".
 * 1) Initialize resultIndex, left and right with 0.
 * 1a) resultIndex is used to update the source back.
 * 1b) left and right is used to traverse and compare character.
 * 2) If char[left]==char[right] increment right.
 * 3) If char[left]!=char[right], need to update source.
 * 3a) To update source 2 things are needed. Character to be updated. Count of Character to be updated
 * 3b) Pick character from left.
 * 3c) Pick count of character from "right-left"
 */
public class StringCompression {
  private int resultIndex, left = 0, right = 0;

  public int compress(char[] chars) {
    while (right < chars.length) {
      if (chars[left] == chars[right]) right++;
      else {
        updateSource(right - left, chars);
        left = right;
      }
    }
    // for the last set of character
    updateSource(right - left, chars);
    return resultIndex;
  }

  private void updateSource(final int count, final char[] chars) {
    chars[resultIndex++] = chars[left]; // update character
    if (count > 1) {
      for (char c : (count + "").toCharArray()) chars[resultIndex++] = c; // update count
    }
  }
}
