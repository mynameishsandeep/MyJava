package com.interview.leetcode.google.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
 * 1) Serialize: (Modified Level Order Traversal. If node is null then insert 0)
 * 		a) Logic is not inserting "O or #" for end of level. It is about inserting "0 or #" for leaf node alone.
 * 		b) =====Note: I don't have to worry about level at all....=========
 * 		c) For each node. Insert the size of the childNode. For the leaf node size will be 0.
 * 			   
 * 2) De-Serialize:(Queue approach, but not level order traversal. one loop to iterate parent and second loop to create child nodes and assign it to parent)
 * 		a) Split the string by ","
 * 		b) Take the 0th data and construct root.
 * 		c) Iterate from the 1st node data. Create node and add it to the parent node. Keep do this till q.size>0 
 * 		d) The main problem here is about keeping the child size of each node. 
 * 		   In case of binary tree size is always 2, so, i can iterate 2 times inside the while loop.   
 * 		   But in n-ary size needs to be saved as Pair with "Node" and "neighborSize" which is a tricky solution. 
 * 
 * ======When i take a node from queue and go inside loop to "create child node" and "set the child node to parent node", 
 * index of array (where child nodes are created) needs to be matched, watch the logic carefully============== 
 */

public class SerializeAndDeserializeN_aryTree {
	public static final String ZERO = "0";
	public static final String COMMA = ",";

	public String serialize(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		StringBuilder result = new StringBuilder();
		while (q.size() > 0) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				if (node == null) {
					result = result.append(ZERO + COMMA);
				} else {
					result.append(node.val + COMMA);
					List<Node> nodeList = node.children;
					if (nodeList != null && nodeList.size() > 0) {
						result.append(nodeList.size() + COMMA);
						for (int j = 0; j < nodeList.size(); j++) {
							q.offer(nodeList.get(j));
						}
					} else {
						result = result.append(ZERO + COMMA);
					}

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

	public Node deserialize(String data) {
		if (null == data) {
			return null;
		}
		String dataArray[] = data.split(COMMA);
		Node root = new Node(new Integer(dataArray[0]), new ArrayList<>());
		Pair parentPair = new Pair(root, dataArray[1]);
		Queue<Pair> q = new LinkedList<>();
		q.offer(parentPair);
		int dataIndex = 2;// index 0 and 1 are consumed and root node is created already
		while (q.size() > 0) {
			parentPair = q.poll();
			Node parentNode = parentPair.node;
			int neighborSize = parentPair.neighborSize;
			while (neighborSize > 0) {
				Node child = new Node(Integer.valueOf(dataArray[dataIndex]), new ArrayList<>());
				parentNode.children.add(child);
				q.offer(new Pair(child, dataArray[dataIndex + 1]));
				dataIndex += 2;
				neighborSize--;
			}
		}
		return root;
	}

}
