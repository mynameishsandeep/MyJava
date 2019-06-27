package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * https://leetcode.com/problems/accounts-merge/

Condition:
1) Person can create account with same name but different id.
2) So if same person create account multiple time. Every time he can give one  primary of different
id and multiple different id.
3) So if a person name matches and if any 1 mail id matches merge it.
4) Person with same name can be 2 different, if no mail id matches.

Input:
[["David","David0@m.co","David4@m.co","David3@m.co"],
["David","David5@m.co","David5@m.co","David0@m.co"],
["David","David1@m.co","David4@m.co","David0@m.co"],
["David","David0@m.co","David1@m.co","David3@m.co"],
["David","David4@m.co","David1@m.co","David3@m.co"]]

Expected:
[["David","David0@m.co","David1@m.co","David3@m.co","David4@m.co","David5@m.co"]]

Solution Approach:

1) Converting into Set will remove duplicates.
2) take first row.. compare with rest of row. If mail matches. merge with prev row. remove current row.
3) Goto step2.
4) Out of memory exception, merge logic. Should be done in graph.
 *
 *
 */

public class AccountsMerge_BruteForce {
  class NamePair {
    String name;
    Set<String> mail;

    public NamePair(String name, Set<String> mail) {
      this.name = name;
      this.mail = mail;
    }
  }

  private boolean matchesAny(NamePair prev, NamePair current) {
    Set<String> prevMail = prev.mail;
    Set<String> currentMail = current.mail;
    for (String s : prevMail) {
      if (currentMail.contains(s)) {
        return true;
      }
    }
    return false;
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    List<NamePair> list = new ArrayList<>();
    for (List<String> account : accounts) {
      String name = account.remove(0);
      NamePair n = new NamePair(name, new TreeSet<>(account));
      list.add(n);
    }
    outer:
    for (int i = 1; i < list.size(); i++) {
      NamePair prev = list.get(i - 1);
      for (int j = i; j < list.size(); j++) {
        NamePair current = list.get(j);
        if (prev.name.equals(current.name) && matchesAny(prev, current)) {
          prev.mail.addAll(current.mail);
          list.remove(j);
          i = 0; // Because i++ will increase it to 1
          continue outer;
        }
      }
    }
    List<List<String>> result = new ArrayList<>();
    for (NamePair np : list) {
      List<String> res = new ArrayList<>();
      res.add(np.name);
      res.addAll(np.mail);
      result.add(res);
    }
    return result;
  }
}
