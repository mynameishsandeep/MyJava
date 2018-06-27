package com.sample.datastructure.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfTree {

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

	private void addElementToMap(Map<Integer, Integer[]> map, Integer data, Integer index) {
		if (map.containsKey(index)) {
			Integer i[] = map.get(index);
			i[1] = data;
			map.put(index, i);
		} else {
			map.put(index, new Integer[]{data});
		}
	}

	public void levelOrderTraverse(Node root, int index, Map<Integer, Integer[]> map) {
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


	void topView(Node root) {
        Map<Integer, Integer[]> map = new TreeMap<>();
		levelOrderTraverse(root, 0, map);
		for (Map.Entry<Integer, Integer[]> mapItem : map.entrySet()) {
			Integer i[] = mapItem.getValue();
            System.out.print(i[0] + " ");
            if(i.length>1) {
                System.out.print(i[1]+ " ");
            }
		}
    }
}
