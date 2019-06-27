package com.interview.leetcode.facebook.medium;

/*
 *
 * Look into the tree structure "DecodeWays_DP.jpg" in US Problems
 *
 * 1) Single character match ( 1 to 9)
 * 2) Two character match (10 to 26)
 * 3) If there is a zero in the beginning, then result 0. Because 0 cannot be used with any next combination of digits.
 * 4) 0 in the middle can("1201") or cannot(301) be used to get result count
 * 4) For Empty String "". result is 0.
 *
 *
 * 1201 --> [1,20,1] // only 1 result count
 * 0121 --> 0 count
 * 301 --> 0 count
 * 01 --> 0 count
 *
 * ===Note: Start processing from Second character =======
 * Because for 1 character result is 1 always.
 *
 * Ex: 10...
 * For 1st digit = f(n) = f(n-1); //
 * For 2nd digit = f(n) = f(n) + f(n-2)
 * ========
 *  For 123 below is the matrix
 *  f(n-2)  f(n-1) f(n)
 *  1       1       2 --> for 12
 *  1       2       0 --> move state
 *
 * ====
 */
public class DecodeWays_DP {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }
    int fN = 0;
    int fNMinus1 = 1;
    int fNMinus2 = fNMinus1;
    for (int i = 1; i < s.length(); i++) { // Just think of input 10
      fN = 0; // this line is needed. Ex: 100
      if (s.charAt(i) == '0') {
        // if 0 do nothing
      } else { // Look for 1 to 9. copy previous
        fN = fNMinus1; // f(n) = f(n-1);
      }

      int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
      if (twoDigit >= 10 && twoDigit <= 26) {
        fN = fN + fNMinus2; // if >=10 && <= 26. add current and previous.previous
        // f(n) = f(n) + f(n-2);
      }
      fNMinus2 = fNMinus1;
      fNMinus1 = fN;
    }
    return fNMinus1;
  }

  public static void main(String[] args) {
    DecodeWays_DP d = new DecodeWays_DP();
    System.out.println(d.numDecodings("1234")); // [1234] [12,3,4][1,23,4]
    System.out.println(d.numDecodings("12"));
    // System.out.println(d.numDecodings("10"));
    // System.out.println(d.numDecodings("10"));
  }
}
