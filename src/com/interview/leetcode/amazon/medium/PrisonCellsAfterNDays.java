package com.interview.leetcode.amazon.medium;

public class PrisonCellsAfterNDays {
  public int[] prisonAfterNDays(int[] cells, int N) {
    if (N == 0) return cells;
    N = N % 14 == 0 ? 14 : N % 14;

    int[] newCells = new int[8];

    while (N-- > 0) {
      for (int i = 1; i < 7; i++)
        if (cells[i - 1] == cells[i + 1]) newCells[i] = 1;
        else newCells[i] = 0;
      cells = newCells;
      newCells = new int[8];
    }

    return cells;
  }
}
