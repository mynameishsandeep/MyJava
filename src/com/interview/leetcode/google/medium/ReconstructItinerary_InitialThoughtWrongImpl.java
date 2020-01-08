package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

https://leetcode.com/problems/reconstruct-itinerary/

Input = [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
Expected = ["JFK","NRT","JFK","KUL"]
Wrong Output = ["JFK","KUL","NRT","JFK"]==> Because after KUL there is not "from" point with KUL.


Below solution will fail for above test case.
 */
public class ReconstructItinerary_InitialThoughtWrongImpl {
  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, TreeMap<String, Boolean>> map = new HashMap<>();
    for (List<String> ticket : tickets) {
      String from = ticket.get(0);
      String to = ticket.get(1);
      if (map.containsKey(from)) map.get(from).put(to, false);
      else {
        TreeMap<String, Boolean> tMap = new TreeMap<>();
        tMap.put(to, false);
        map.put(from, tMap);
      }
    }
    List<String> result = new ArrayList<>();
    recur(map, "JFK", result);
    return result;
  }

  private void recur(Map<String, TreeMap<String, Boolean>> map, String from, List<String> result) {
    result.add(from);
    TreeMap<String, Boolean> tMap = map.get(from);
    if (tMap != null) {
      for (Map.Entry<String, Boolean> entry : tMap.entrySet()) {
        if (!entry.getValue()) {
          entry.setValue(true);
          recur(map, entry.getKey(), result);
        }
      }
    }
  }
}
