package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/alien-dictionary/
 *
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/6610306698575872
 * =======Initialization Trick==========
 * if it is not initialized with all characters, below case will fail.
 *
 * ["z","z"]
 * 
 * This will make source to empty. 
 * =======================================
 *
 */
public class AlienDictionary_TopologicalSort_AlternateWrongApproach {
  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) return "";

    // a. Initialize the graph. Improper Initialization
    HashMap<Character, Integer> inDegree =
        new HashMap<>(); // count of incoming edges for every vertex
    HashMap<Character, List<Character>> graph = new HashMap<>(); // adjacency list graph

    // b. Build the graph
    for (int i = 0; i < words.length - 1; i++) {
      String w1 = words[i], w2 = words[i + 1]; // find ordering of characters from adjacent words
      for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
        char parent = w1.charAt(j), child = w2.charAt(j);
        if (parent != child) { // if the two characters are different
          System.out.println(parent + " " + child);

          if (graph.containsKey(parent)) {
            graph.get(parent).add(child);
          } else {
            graph.put(parent, new ArrayList<>(Arrays.asList(child)));
            System.out.println("after " + graph);
          }
          if (inDegree.containsKey(child)) {
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
          } else {
            inDegree.put(child, 1);
          }

          break; // only the first different character between the two words will help us find the
          // order
        }
      }
    }
    System.out.println(graph);
    System.out.println(inDegree);
    // c. Find all sources i.e., all vertices with 0 in-degrees
    Queue<Character> sources = new LinkedList<>();
    for (Character key : graph.keySet()) {
      if (!inDegree.containsKey(key)) sources.add(key);
    }
    System.out.println(sources);
    // d. For each source, add it to the sortedOrder and subtract one from all of its children's
    // in-degrees
    // if a child's in-degree becomes zero, add it to the sources queue
    StringBuilder sortedOrder = new StringBuilder();
    while (!sources.isEmpty()) {
      Character vertex = sources.poll();
      sortedOrder.append(vertex);
      List<Character> children =
          graph.get(vertex); // get the node's children to decrement their in-degrees
      System.out.println("children" + children);
      if (children != null) {
        for (Character child : children) {
          inDegree.put(child, inDegree.get(child) - 1);
          if (inDegree.get(child) == 0) sources.add(child);
        }
      }
    }
    System.out.println(sortedOrder);
    // if sortedOrder doesn't contain all characters, there is a cyclic dependency between
    // characters, therefore, we
    // will not be able to find the correct ordering of the characters
    // if (sortedOrder.length() != inDegree.size())
    //   return "";

    return sortedOrder.toString();
  }
}
