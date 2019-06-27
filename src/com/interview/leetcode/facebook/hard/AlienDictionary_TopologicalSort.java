package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/alien-dictionary/
 *
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/6610306698575872
 *
 * 1) Question and samples are tricky.
 * 2) Input words are lexicographically sorted.
 * Ex1: "abc" and "abd". On this word only one criteria is confirmed. c comes before d. a and b can come anywhere.
 * Ex2: "abcd" and "abxy". Still on this word only one criteria is confirmed. c comes before x. a, b, d, y can come anywhere.
 * 3) only difference in input as compared to graph relation is build the graph of the characters by
 * comparing adjacent words first, and then perform the topological sort for the graph to determine the order of the characters.
 *
 * =======Initialization Trick==========
 * 1) All characters will form graph. So fill adjMatrix with all the character in word. Duplicate will override.
 * 2) Also fill inDegree for all character to 0;
 * =======================================
 * ======Finding sources firsttime and then afterwards ======
 * 1) First time source are found out by "inDegree" with size 0.
 * 2) For the second time and there after,
 * When a source is processed, corresponding neighbor in-degree count is reduced.
 * If a in-degree count is 0, then it can be added to source.
 * =============================
 * If there is a loop then sortedOrder doesn't match with inDegree. So return "" in that case.
 */
public class AlienDictionary_TopologicalSort {
  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) return "";

    // a. Initialize the graph
    HashMap<Character, Integer> inDegree =
        new HashMap<>(); // count of incoming edges for every vertex
    HashMap<Character, List<Character>> adjMatrix = new HashMap<>(); // adjacency list graph
    for (String word : words) {
      for (char character : word.toCharArray()) {
        inDegree.put(character, 0);
        adjMatrix.put(character, new ArrayList<Character>());
      }
    }

    // b. Build the graph
    for (int i = 0; i < words.length - 1; i++) {
      String parentWord = words[i],
          childWord = words[i + 1]; // find ordering of characters from adjacent words
      for (int j = 0; j < Math.min(parentWord.length(), childWord.length()); j++) {
        char parentChar = parentWord.charAt(j), childChar = childWord.charAt(j);
        System.out.println(parentChar + " " + childChar);
        if (parentChar != childChar) { // if the two characters are different
          adjMatrix.get(parentChar).add(childChar); // put the child into it's parent's list
          inDegree.put(childChar, inDegree.get(childChar) + 1); // increment child's inDegree
          break; // only the first different character between the two words will help us find the
          // order
        }
      }
    }
    // c. Find all sources i.e., all vertices with 0 in-degrees
    Queue<Character> sources = new LinkedList<>();
    for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) sources.add(entry.getKey());
    }

    // d. For each source, add it to the sortedOrder and subtract one from all of its children's
    // in-degrees
    // if a child's in-degree becomes zero, add it to the sources queue
    StringBuilder sortedOrder = new StringBuilder();
    while (!sources.isEmpty()) {
      Character vertex = sources.poll();
      sortedOrder.append(vertex);
      List<Character> children =
          adjMatrix.get(vertex); // get the node's children to decrement their in-degrees
      for (Character child : children) {
        inDegree.put(child, inDegree.get(child) - 1);
        if (inDegree.get(child) == 0) sources.add(child);
      }
    }

    // if sortedOrder doesn't contain all characters, there is a cyclic dependency between
    // characters, therefore, we
    // will not be able to find the correct ordering of the characters
    if (sortedOrder.length() != inDegree.size()) return "";

    return sortedOrder.toString();
  }
}
