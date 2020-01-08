package com.interview.leetcode.apple.medium;

import java.util.Set;

/*
 * https://leetcode.com/problems/android-unlock-patterns/


1) Permute all the combinations in graph
2) If a combination is invalid at a point, backtrack with new combination.
 */
public class AndroidUnlockPatterns {
  public int numberOfPatterns(int m, int n) {
    int[] sol = new int[1];
    boolean[] used = new boolean[9];
    Set<Integer> corner = Set.of(1, 3, 7, 9);
    Set<Integer> side = Set.of(2, 4, 6, 8);
    dfs(0, -1, m, n, sol, used, corner, side);
    return sol[0];
  }

  public void dfs(
      int len,
      int pre,
      int m,
      int n,
      int[] sol,
      boolean[] used,
      Set<Integer> corner,
      Set<Integer> side) {
    if (len >= m) sol[0]++;
    if (len == n) return;
    for (int i = 1; i < 10; i++) {
      if (used[i - 1]) continue;
      if (corner.contains(i) && corner.contains(pre) && !used[(i + pre) / 2 - 1]) continue;
      if (!used[4] && side.contains(i) && side.contains(pre) && i + pre == 10) continue;
      used[i - 1] = true;
      dfs(len + 1, i, m, n, sol, used, corner, side);
      used[i - 1] = false;
    }
  }
}
