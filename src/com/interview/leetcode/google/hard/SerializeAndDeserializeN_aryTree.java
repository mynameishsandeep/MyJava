package com.interview.leetcode.google.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.interview.leetcode.Node;

/*
* https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
*
* See image for how it is saved "SerializeDeSerializeN_aryTree.JPG"
*
* Serialization can be done in any ways, as long as it can be de-serialized.
* https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/description/
*
* 1) In case of binary tree size is always 2, so, i can iterate 2 times inside the while loop.
* 2) But in n-ary size needs to be saved as Pair with "Node" and "neighborSize" which is a tricky solution.

* 							1
* 						3	    2     4
* 					   5  6
*
* 1 has (3,2,4)
* 3 has (5,6)
* Serialized Data : 1,3,3,2,2,0,4,0,5,0,6,0
*
*/

public class SerializeAndDeserializeN_aryTree {

  public String serialize(Node root) {
    if (root == null) {
      return null;
    }
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    StringBuilder result = new StringBuilder();
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node n = q.poll();
        result.append(n.val + "," + n.children.size() + ",");
        for (int j = 0; j < n.children.size(); j++) {
          q.offer(n.children.get(j));
        }
      }
    }
    return result.substring(0, result.length() - 1);
  }

  public class Pair {
    public Node node;
    public int neighborSize;

    public Pair(Node node, String neighborSize) {
      this.node = node;
      this.neighborSize = Integer.valueOf(neighborSize);
    }
  }

  /*
   * When i take a node from queue and go inside loop to "create child node" and "set the child node to parent node",
   * index of array (where child nodes are created) needs to be matched, watch the logic carefully
   */
  public Node deserialize(String data) {
    if (null == data) {
      return null;
    }
    String dataArray[] = data.split(",");
    Node root = new Node(new Integer(dataArray[0]), new ArrayList<>());
    Pair parentPair = new Pair(root, dataArray[1]);
    Queue<Pair> q = new LinkedList<>();
    q.offer(parentPair);
    int dataIndex = 2; // index 0 and 1 are consumed and root node is created already
    while (!q.isEmpty()) {
      parentPair = q.poll();
      Node parentNode = parentPair.node;
      int neighborSize = parentPair.neighborSize;
      while (neighborSize > 0) {
        Node child = new Node(Integer.valueOf(dataArray[dataIndex]), new ArrayList<>());
        parentNode.children.add(child);
        q.offer(new Pair(child, dataArray[dataIndex + 1]));
        dataIndex += 2; // node value and child size are consumed. So increment by2
        neighborSize--;
      }
    }
    return root;
  }
}
