package com.interview.leetcode.facebook.easy;

/*
 * https://leetcode.com/problems/valid-word-abbreviation/
 *

word = "internationalization", abbr = "i12iz4n":

1) Compare char by char on word with abbr.
2) If abbr is number, take all succssive number, ex: we see 1 and then take 2 also.
3) increase i by that many count. Goto step 1.


Edge Case: 0 at first should be considered as equals.
"a"
"01"

 */
public class ValidWordAbbreviation {
  public boolean validWordAbbreviation(String word, String abbr) {
    int i = 0, j = 0;
    while (true) {
      if (i >= word.length() && j >= abbr.length()) {
        return true;
      }
      if (i >= word.length() || j >= abbr.length()) {
        return false;
      }
      char w = word.charAt(i);
      char a = abbr.charAt(j);
      String aS = "";
      if (Character.isDigit(a) && a != '0') {
        aS = a + "";
        for (j = j + 1; j < abbr.length(); j++) {
          a = abbr.charAt(j);
          if (Character.isDigit(a)) {
            aS += a;
          } else {
            break;
          }
        }
        i = i + Integer.valueOf(aS);
        if (i > word.length()) {
          return false;
        }
      } else if (w != a) {
        return false;
      } else {
        i++;
        j++;
      }
    }
  }
}
