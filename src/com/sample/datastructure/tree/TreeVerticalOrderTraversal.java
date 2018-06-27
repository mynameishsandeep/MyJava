package com.sample.datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
 * 
 * 1) Traverse tree in Level order.(Note : Traversing tree in in/pre/post order will fail in many corner cases.)
 * 2) Save the index with data in map. 
 * 3) From the map, return index data from smallest 
 * 
 * Note : Wrap the Node with index to save index for each node. This NodeWithIndex will be added with +1 for right - for left.
 */
public class TreeVerticalOrderTraversal {
	class Node {
		int data;
		Node left;
		Node right;
	}

	class NodeWithIndex {
		Node node;
		int index;

		public NodeWithIndex(Node node, int index) {
			this.node = node;
			this.index = index;
		}
	}

	Node root;

	public void add(int data) {
		Node tempRoot = root;
		Node currNode = new Node();
		currNode.data = data;
		if (tempRoot == null) {
			root = currNode;
		} else {
			while (true) {
				if (data < tempRoot.data) {
					if (tempRoot.left != null) {
						tempRoot = tempRoot.left;
					} else {
						tempRoot.left = currNode;
						break;
					}
				} else {
					if (tempRoot.right != null) {
						tempRoot = tempRoot.right;
					} else {
						tempRoot.right = currNode;
						break;
					}
				}
			}
		}
	}

	private void addElementToMap(Map<Integer, List<Integer>> map, Integer data, Integer index) {
		if (map.containsKey(index)) {
			List<Integer> l = map.get(index);
			l.add(data);
			map.put(index, l);
		} else {
			map.put(index, new LinkedList<>(Arrays.asList(data)));
		}
	}

	public void levelOrderTraverse(Node root, int index, Map<Integer, List<Integer>> map) {
		if (root == null) {
			return;
		}
		Queue<NodeWithIndex> q = new LinkedList<>();
		q.offer(new NodeWithIndex(root, 0));
		addElementToMap(map, root.data, 0);
		while (q.size() > 0) {
			NodeWithIndex temp = q.poll();
			if (temp.node.left != null) {
				addElementToMap(map, temp.node.left.data, temp.index - 1);
				q.offer(new NodeWithIndex(temp.node.left, temp.index - 1));
			}
			if (temp.node.right != null) {
				addElementToMap(map, temp.node.right.data, temp.index + 1);
				q.offer(new NodeWithIndex(temp.node.right, temp.index + 1));
			}
		}
	}

	public static void main(String[] args) {
		TreeVerticalOrderTraversal p = new TreeVerticalOrderTraversal();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(6);
		p.add(20);
		p.add(30);
		p.add(15);
		//		p.add(21);
		//		p.add(22);
		Map<Integer, List<Integer>> map = new TreeMap<>();
		p.levelOrderTraverse(p.root, 0, map);
		List<List<Integer>> result = new ArrayList<>();
		for (Map.Entry<Integer, List<Integer>> mapItem : map.entrySet()) {
			result.add(mapItem.getValue());
		}
		System.out.println(result);
	}

}
