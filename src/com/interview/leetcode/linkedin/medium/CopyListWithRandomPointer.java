package com.interview.leetcode.linkedin.medium;

import java.util.HashMap;
import java.util.Map;

import com.interview.leetcode.doublelinkedlist.Node;

/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * The main focus of the problem is random pointer which points to the node which is not yet created in the targetNode.
 * So in below approach we create target node in first loop and in second loop map the random pointer using hashmap.
 * So it is 2-pass solution.
 *
 * 1) In first iteration clone all node from head to tail leaving random pointer.
 * 2) Save the map of source node to target node in map.
 * 3) In second iteration, set the value of random pointer
 */
public class CopyListWithRandomPointer {
  public Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    Node targetNode = cloneNode(head, map);
    setRandomPointer(head, targetNode, map);
    return targetNode;
  }

  public void setRandomPointer(Node sourceNode, Node targetNode, Map<Node, Node> map) {
    while (sourceNode != null) {
      if (sourceNode.random != null) {
        targetNode.random = map.get(sourceNode.random);
      }
      sourceNode = sourceNode.next;
      targetNode = targetNode.next;
    }
  }

  public Node cloneNode(Node sourceNode, Map<Node, Node> map) {
    Node targetNode = null;
    Node prevNode = null;
    while (sourceNode != null) {
      Node currNode = new Node(sourceNode.val);
      map.put(sourceNode, currNode);
      if (prevNode != null) {
        prevNode.next = currNode;
      } else { // Execute only during the first time
        targetNode = currNode;
      }
      prevNode = currNode;
      sourceNode = sourceNode.next;
    }
    return targetNode;
  }
}
