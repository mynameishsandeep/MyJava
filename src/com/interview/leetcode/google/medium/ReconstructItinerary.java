package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*

https://leetcode.com/problems/reconstruct-itinerary/
https://leetcode.com/problems/reconstruct-itinerary/discuss/367249/Intuitive-Java-Solution-With-Explanation

Input = [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
Expected = ["JFK","NRT","JFK","KUL"]
Wrong Output = ["JFK","KUL","NRT","JFK"]==> Because after KUL there is not "from" point with KUL.


==============Solution Note====================
1) This solution pushes the dead-end node to last by doing "res.addFirst(s)" which is a post-order traversal.
Ex: in above test case "KUL" is dead-end.
2) It is possible only because of condition "there must exist an itenary of all tickets
(so we are sure we will connect the dead-ends eventually by dfs)."
=======================Solution Alternate==========
1) Once we find dead-end. BackTrack "offer" elements back go with next combination. But that code is too much
 */
public class ReconstructItinerary {
  HashMap<String, PriorityQueue<String>> map = new HashMap<>();
  LinkedList<String> res = new LinkedList<>();

  public List<String> findItinerary(List<List<String>> tickets) {
    for (List<String> ticket : tickets) {
      if (!map.containsKey(ticket.get(0))) {
        PriorityQueue<String> q = new PriorityQueue<>();
        map.put(ticket.get(0), q);
      }
      map.get(ticket.get(0)).offer(ticket.get(1));
    }
    dfs("JFK");
    return res;
  }

  public void dfs(String s) {
    PriorityQueue<String> q = map.get(s);
    while (q != null && !q.isEmpty()) {
      dfs(q.poll());
    }
    res.addFirst(s);
  }
}
