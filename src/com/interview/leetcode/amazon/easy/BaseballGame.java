package com.interview.leetcode.amazon.easy;

/*
 * 
 * https://leetcode.com/problems/baseball-game/submissions/
 * 
Number -> just add
+ -> current and previous
D -> previous * 2
C -> cancel previous

*/

public class BaseballGame {

  public int calPoints(String[] ops) {
    int cache[] = new int[ops.length];
    int i = 0;
    for (String s : ops) {
      switch (s) {
        case "+":
          cache[i] = cache[i - 2] + cache[i - 1];
          i++;
          break;
        case "D":
          cache[i] = 2 * cache[i - 1];
          i++;
          break;
        case "C":
          i--;
          break;
        default:
          cache[i++] = Integer.valueOf(s);
      }
    }
    int result = 0;
    for (int j = 0; j < i; j++) {
      result += cache[j];
    }
    return result;
  }
}
