package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/find-the-town-judge/
 * 
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

1)The town judge trusts nobody.
2)Everybody (except for the town judge) trusts the town judge.
3)There is exactly one person that satisfies properties 1 and 2.

 */
public class FindTheTownJudge {

  public int findJudge(int N, int[][] trust) {
    int[] judge = new int[N + 1];
    for (int[] pair : trust) {
      judge[pair[0]]--;
      judge[pair[1]]++;
    }
    for (int i = 1; i <= N; i++) {
      if (judge[i] == N - 1) return i; // There is exactly one person that satisfies properties 1 and 2.
    }
    return -1;
  }
}
