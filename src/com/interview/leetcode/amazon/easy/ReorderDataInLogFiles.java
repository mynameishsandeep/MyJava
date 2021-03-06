package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {
  public String[] reorderLogFiles(String[] logs) {
    Comparator<String> myComp =
        (final String s1, final String s2) -> {
          int s1si = s1.indexOf(' ');
          int s2si = s2.indexOf(' ');
          char s1fc = s1.charAt(s1si + 1);
          char s2fc = s2.charAt(s2si + 1);

          if (s1fc <= '9') {
            if (s2fc <= '9') return 0;
            return 1;
          }
          if (s2fc <= '9') return -1;

          int preCompute = s1.substring(s1si + 1).compareTo(s2.substring(s2si + 1));
          if (preCompute == 0) return s1.substring(0, s1si).compareTo(s2.substring(0, s2si));
          return preCompute;
        };

    Arrays.sort(logs, myComp);
    return logs;
  }
}
