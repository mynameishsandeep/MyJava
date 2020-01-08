package com.interview.leetcode.facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/accounts-merge/
 *
 * 1) Each List contains first entry as name and then email name.
 * 2) Same mail id registered in 2 entry needs to be merged.
 * 3) If mail id matches then name will match. No need to compare on this.
 * ==========Implementation Notes ====
 * 1) Save each email id and

Input : [["John","johnsmith@mail.com"],["John","johnsmith@mail.com","john00@mail.com"]]
Output : [["John","john00@mail.com","johnsmith@mail.com"]]
 *
 */
public class AccountsMerge_Graph_DFS {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Set<String>> adjMatrix = new LinkedHashMap<>(); // <email node, neighbor nodes>
    Map<String, String> emailAndName = new HashMap<>(); // <email, username>
    buildAdjMatrix(accounts, adjMatrix, emailAndName);

    Set<String> visited = new HashSet<>();
    List<List<String>> res = new LinkedList<>();

    for (String email : emailAndName.keySet()) {
      List<String> list = new LinkedList<>();
      if (visited.add(email)) {
        dfs(adjMatrix, email, visited, list);
        Collections.sort(list);
        list.add(0, emailAndName.get(email));
        res.add(list);
      }
    }

    return res;
  }

  public void dfs(
      Map<String, Set<String>> adjMatrixMap, String email, Set<String> visited, List<String> list) {
    list.add(email);
    for (String next : adjMatrixMap.get(email)) {
      if (!visited.contains(next)) {
        visited.add(next);
        dfs(adjMatrixMap, next, visited, list);
      }
    }
  }

  /*
   * Ex: [a,a@m.com] 			==> adjMatrix = [[a@m.com,[]]]
   * 							==> name = [[a@m.com,a]]
   * Ex: [a,a@m.com, b@m.com]   ==> adjMatrix = [[a@m.com,[b@m.com]],[b@m.com, [a@m.com]]]
   * 							==> name = [[a@m.com,a]]
   */
  private void buildAdjMatrix(
      List<List<String>> accounts, Map<String, Set<String>> adjMatrix, Map<String, String> name) {
    for (List<String> account : accounts) {
      String userName = account.get(0);
      name.put(account.get(1), userName);
      if (!adjMatrix.containsKey(account.get(1))) adjMatrix.put(account.get(1), new HashSet<>());
      for (int i = 2; i < account.size(); i++) {
        if (!adjMatrix.containsKey(account.get(i))) adjMatrix.put(account.get(i), new HashSet<>());
        adjMatrix.get(account.get(i)).add(account.get(i - 1));
        adjMatrix.get(account.get(i - 1)).add(account.get(i));
      }
    }
  }

  public static void main(String[] args) {
    AccountsMerge_Graph_DFS a = new AccountsMerge_Graph_DFS();
    List<List<String>> accounts = new ArrayList<>();
    List<String> a1 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
    List<String> a2 = Arrays.asList("John", "johnnybravo@mail.com");
    List<String> a3 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
    List<String> a4 = Arrays.asList("Mary", "mary@mail.com");
    accounts.add(a1);
    accounts.add(a2);
    accounts.add(a3);
    accounts.add(a4);
    a.accountsMerge(accounts);
  }
}
