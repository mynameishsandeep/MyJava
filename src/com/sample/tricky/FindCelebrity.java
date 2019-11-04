package com.sample.tricky;

/*
* https://leetcode.com/problems/find-the-celebrity/discuss/
*
* There will be only 1 celebrity or no celebrity
==============BruteForce================
1) For each candidate call other candidate.
Time Complexity : O(n^2)
================Better Solution================
1) Find a candidate who is not known by anyone. He is the ideal candidate.
2) Make sure "he knows no one" and "no one known him"
*/
public class FindCelebrity {

  public int findCelebrity(int n) {
    int candidate = 0;
    for (int i = 1; i < n; i++) {
      if (knows(candidate, i)) {
        candidate = i;
      }
    }
    for (int i = 0; i < n; i++) {
      if (i == candidate) continue;
      if (knows(i, candidate) && !knows(candidate, i)) {
        // candidate is good
      } else {
        return -1;
      }
    }
    return candidate;
  }

  // Not completed fully
  public boolean knows(int i, int j) {
    return true;
  }
}
