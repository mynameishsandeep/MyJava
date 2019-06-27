package com.interview.leetcode.linkedin.hard;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/minimum-window-substring/description/

 * Note1: Moving leftIndex and rightIndex
 * 1) Keep leftIndex and rightIndex at 0.
 * 2) Move rightIndex alone, till first window.
 * 3) Move leftIndex and rightIndex after first window reached.

 * Note2:How to update map and count of "noOfMatchingChar"
 * 1) If a rightIndex char exists in searchString. Decrement the map count on char and increase noOfMatchingChar
 * 2) If a leftIndex char exists in searchString. Increment the map count on char and decrease noOfMatchingChar
 *
 * Logic : At any point when "noOfMatchingChar" == mapSize a result is found
 *
Input String : ZAABBCA , Search String : ABBC
Window Found : ZAABBC --> Only Right Moved till this point
Window Found : AABBC -->Only left moves
Window Found : ABBC --> Only left moves
Window Found : BBCA

 */
public class MinimumWindowSubstring {
  int noOfMatchingChar = 0;
  int leftIndex = 0;
  int rightIndex = 0;
  int minLeftIndex = 0;
  int minRightIndex = 0;
  int minWindowLength = 0;
  HashMap<Character, Integer> map = new HashMap<>();
  String inputString;
  String searchString;

  public String minWindow(String s, String t) {
    this.inputString = s;
    this.searchString = t;
    minWindowLength = s.length() + 1;
    if (s.length() < t.length() || s.length() == 0) {
      return "";
    }
    for (char c : t.toCharArray()) {
      if (map.containsKey(c)) map.put(c, map.get(c) + 1);
      else map.put(c, 1);
    }
    for (; rightIndex < s.length(); rightIndex++) {
      char rightIndexChar = inputString.charAt(rightIndex);
      if (map.containsKey(rightIndexChar)) {
        map.put(rightIndexChar, map.get(rightIndexChar) - 1);
        if (map.get(rightIndexChar) >= 0) {
          noOfMatchingChar++;
        }
        moveLeft();
      }
    }
    if (minWindowLength > s.length()) {
      return "";
    }

    return s.substring(minLeftIndex, minLeftIndex + minWindowLength);
  }

  private void updateResultWindow() {
    System.out.println("Window Found : " + inputString.substring(leftIndex, rightIndex + 1));

    if (rightIndex - leftIndex + 1 < minWindowLength) {
      minLeftIndex = leftIndex;
      minRightIndex = rightIndex;
      minWindowLength = minRightIndex - minLeftIndex + 1;
    }
  }

  private void moveLeft() {
    // Left is moved when a window is found.
    while (noOfMatchingChar == searchString.length()) {
      updateResultWindow();
      char leftIndexChar = inputString.charAt(leftIndex);
      if (map.containsKey(leftIndexChar)) {
        map.put(leftIndexChar, map.get(leftIndexChar) + 1);
        if (map.get(leftIndexChar) > 0) {
          noOfMatchingChar--;
        }
      }
      leftIndex++;
    }
  }

  public static void main(String[] args) {
    MinimumWindowSubstring m = new MinimumWindowSubstring();
    System.out.println("ZAABBCA");
    System.out.println(m.minWindow("ZAABBCA", "ABBC"));
    // System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
    // System.out.println(m.minWindow("AA", "AA"));
    // System.out.println(m.minWindow("acbbaca", "aba"));
    // System.out.println(m.minWindow("aaflslflsldkalskaaa", "aaa"));
    // System.out.println(m.minWindow("bba", "ab"));

  }
}
