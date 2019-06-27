package com.interview.leetcode.facebook.easy;

/*
 * https://leetcode.com/problems/read-n-characters-given-read4/discuss/252002/Once-you-understand-the-question-it-should-be-straightforward-Java
 * 
 * 1) fill argument "buf" with 4 character every time.
 * 2) "buf" will be initialized by consumer with 512 size.
 *
 */
public class ReadNCharactersGivenRead4 {

  public int read(char[] buf, int n) {
    int i = 0;
    char tempBuf[] = new char[4];
    while (i < n) {
      int total = read4(tempBuf);
      if (total > 0) {
        for (int j = 0; i < n && j < total; j++) {
          buf[i++] = tempBuf[j];
        }
      }
      if (total < 4) {
        return i;
      }
    }
    return i;
  }

  int read4(char[] buf) {
    return 0;
  }
}
