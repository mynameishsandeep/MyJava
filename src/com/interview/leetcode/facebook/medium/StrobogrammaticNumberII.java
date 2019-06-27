package com.interview.leetcode.facebook.medium;

import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 *

======Solution Initial Thinking========
1) 0,1,6,8,9
2) If n=4 from 1000 to 9999 -> Generate number. do palindrome string comparism.
3) This goes timeout error. Due to too many number generation.
======Solution based on Data Analysis=========
    LetterCombinationOfPhoneNumber.png

===============

n=1
[0, 1, 8]

n=2
[]
[11, 69, 88, 96]

n=3
[0, 1, 8]
[101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986]

n=4
[]
[11, 69, 88, 96, 00]
[1111, 6119, 8118, 9116, 1691, 6699, 8698, 9696, 1881, 6889, 8888, 9886, 1961, 6969, 8968, 9966, 1001, 6009, 8008, 9006]

n=5
[0, 1, 8]
[101, 609, 808, 906, 000, 111, 619, 818, 916, 010, 181, 689, 888, 986, 080]
[11011, 61019, 81018, 91016, 16091, 66099, 86098, 96096, 18081, 68089, 88088, 98086, 19061, 69069, 89068, 99066, 10001, 60009, 80008, 90006, 11111, 61119, 81118, 91116, 16191, 66199, 86198, 96196, 18181, 68189, 88188, 98186, 19161, 69169, 89168, 99166, 10101, 60109, 80108, 90106, 11811, 61819, 81818, 91816, 16891, 66899, 86898, 96896, 18881, 68889, 88888, 98886, 19861, 69869, 89868, 99866, 10801, 60809, 80808, 90806]

 *
 */
public class StrobogrammaticNumberII {

  public List<String> FindStrobogrammatic(int n) {

    LinkedList<String> q = new LinkedList<>();
    if (n % 2 == 1) {
      q.offer("0");
      q.offer("1");
      q.offer("8");
    } else {
      q.offer("");
    }

    for (int i = 0; i < n / 2; ++i) {
      int size = q.size();
      for (int j = 0; j < size; j++) {
        String cur = q.poll();

        q.offer("1" + cur + "1");
        q.offer("6" + cur + "9");
        q.offer("8" + cur + "8");
        q.offer("9" + cur + "6");
        if (i < n / 2 - 1) { // Skip inserting 00 at outer
          q.offer("0" + cur + "0");
        }
      }
    }
    return q;
  }
}
