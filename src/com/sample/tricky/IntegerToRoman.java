package com.sample.tricky;

/*
 * https://leetcode.com/problems/integer-to-roman/description/
 *
 * Remember 1 4 5 9 from left till 1000...
 */
public class IntegerToRoman {

  // Below code will work from 1 to 10
  public String intToRomanStepByStepApproach(int num) {
    StringBuilder result = new StringBuilder();
    while (num >= 1) {
      if (num >= 10) {
        result.append("X");
        num = num - 10;
      } else if (num >= 9) {
        result.append("IX");
        num = num - 9;
      } else if (num >= 5) {
        result.append("V");
        num = num - 5;
      } else if (num >= 4) {
        result.append("IV");
        num = num - 4;
      } else {
        result.append("I");
        num = num - 1;
      }
    }
    return result.toString();
  }

  public String intToRoman(int num) {
    int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < numbers.length && num != 0; ) {
      if (num >= numbers[i]) {
        result.append(romanNumbers[i]);
        num = num - numbers[i];
      } else i++;
    }
    return result.toString();
  }
}
