package com.interview.leetcode.facebook.hard;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times
 *
 * This problem is almost same as ReadNCharactersGivenRead4.
 *
 * Save each 4 char in a q. If queue size is greater than or equal to n, then return value from q.
 * Else fill q. Then read q and send response.
 *
 *
 *
 */
public class ReadNCharactersGivenRead4II {
  Queue<Character> q = new LinkedList<>();

  public int read(char[] buf, int n) {
    int bufStart = 0;
    if (q.size() >= n) {
      for (int i = 0; i < n; i++) {
        buf[bufStart++] = q.poll();
      }
    } else {
      fillQ(n);
      for (int i = 0; i < n && !q.isEmpty(); i++) {
        buf[bufStart++] = q.poll();
      }
    }
    return bufStart;
  }

  private void fillQ(int n) {
    char tempBuf[] = new char[4];
    while (n > 0) {
      int total = read4(tempBuf);
      if (total > 0) {
        for (int j = 0; j < total; j++) {
          q.offer(tempBuf[j]);
          n--;
        }
      }
      if (total < 4) {
        break;
      }
    }
  }

  int read4(char[] buf) {
    return 0;
  }
}
