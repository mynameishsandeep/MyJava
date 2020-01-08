package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/excel-sheet-column-number/

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 		===>0*26+1 ===> 1*26+2 ===> 28
    ABC -> 731 		===>0*26+1 ===> 1*26+2 ===> 28*26+3 ===> 731
    ABCD ->19010 	===>0*26+1 ===> 1*26+2 ===> 28*26+3 ===> 731*26+4 ===> 19010
 */
public class ExcelSheetColumnNumber {
  public int titleToNumber(String s) {
    int titleNumber = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int number = (c - 'A' + 1);
      titleNumber = titleNumber * 26 + number;
    }
    return titleNumber;
  }
}
