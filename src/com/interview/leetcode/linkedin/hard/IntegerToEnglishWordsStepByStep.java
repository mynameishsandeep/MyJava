package com.interview.leetcode.linkedin.hard;

/*
 * https://leetcode.com/problems/integer-to-english-words/
 *
 * Simple Understanding code for input 123
 */
public class IntegerToEnglishWordsStepByStep {
  String[] lessThan10 = {"", "One", "Two", "Three"};
  String[] lessThan20 = {"", "Eleven "};
  String[] lessThan100 = {"", "Ten ", "Twenty "};
  StringBuilder result = new StringBuilder();

  public String numberToWords(int num) {
    helper(num);
    return result.toString();
  }

  private void helper(int num) {
    if (num < 10) {
      result.append(lessThan10[num]);
    } else if (num < 20) {

    } else if (num < 100) {
      result.append(lessThan100[num / 10]);
      helper(num % 10);
    } else if (num < 1000) {
      result.append("One Hunderd ");
      helper(num % 100);
    }
  }
}
