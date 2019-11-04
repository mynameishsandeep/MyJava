package com.interview.leetcode.amazon.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/find-the-town-judge/
 *
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

1)The town judge trusts nobody.
2)Everybody (except for the town judge) trusts the town judge.
3)There is exactly one person that satisfies properties 1 and 2.

Corner Case:
3
[[1,3],[2,3],[3,1]]

Output: -1... 3 is possible Judge. But 3 trust 1. So no judge in result.


 */
public class FindTheTownJudge {

  public int findJudge(int N, int[][] trust) {
    int[] judge = new int[N + 1];
    for (int[] pair : trust) {
      judge[pair[0]]--;
      judge[pair[1]]++;
    }
    for (int i = 1; i <= N; i++) {
      if (judge[i] == N - 1)
        return i; // There is exactly one person that satisfies properties 1 and 2.
    }
    return -1;
  }

  public int findJudge1(int N, int[][] trust) {
    if (trust.length == 0) return 1;
    Map<Integer, Integer> judgeMap = new HashMap<>();
    Set<Integer> people = new HashSet<>();
    for (int[] t : trust) {
      int judge = t[1];
      if (judgeMap.containsKey(judge)) judgeMap.put(judge, judgeMap.get(judge) + 1);
      else judgeMap.put(judge, 1);

      people.add(t[0]);
    }
    for (Map.Entry<Integer, Integer> entry : judgeMap.entrySet()) {
      if (entry.getValue() == N - 1) {
        int possibleJudge = entry.getKey();
        if (!people.contains(possibleJudge)) return possibleJudge;
      }
    }
    return -1;
  }
}
