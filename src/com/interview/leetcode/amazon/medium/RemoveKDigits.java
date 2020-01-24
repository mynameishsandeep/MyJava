package com.interview.leetcode.amazon.medium;

/*

input : 112 k=1 Output= 11
input : 100Zeroes 1000 1s 20002s  k=1000 ---> Converting to Integer or Long to skip 0 at beginning will throw NumberFormatException
 */
public class RemoveKDigits {
  public String removeKdigits(String num1, int k) {

    StringBuilder num = new StringBuilder(num1);
    for (int i = 0; i < num.length() - 1 && k > 0; i++) {
      if (i >= 0 && num.charAt(i) > num.charAt(i + 1)) {
        num = num.deleteCharAt(i);
        i = i - 2;
        k--;
      }
    }

    while (num.length() > 0 && num.charAt(0) == '0') {
      num = num.deleteCharAt(0);
    }
    if (k > 0) {
      num.delete(num.length() - k, num.length());
    }
    return num.length() - k >= 1 ? num.substring(0, num.length() - k) : "0";
  }
}
