package com.interview.leetcode.linkedin.medium;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/#
 * =======Below is not the best solution===========
 * =======Below is not the best solution===========
 * Step 1) Take 0th element from each row and offer it on priority queue.
 * Step 2) When poll a element for the first minimum, offer next element from the same row.
 * Step 3) Repeat step2 until k size.
 * 
 * Step 1 can be in built like taking the first row and comparing with each row...
 * Because matrix is sorted row wise and column wise.  
 * 
 *   Note: This problem is similar to MergetKSortedLists
 */
public class KthSmallestElementInASortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		Queue<Tuple> q = new PriorityQueue<>();
		// Adding 1 column from each row to queue
		for (int i = 0; i < matrix.length; i++) {
			Tuple tuple = new Tuple(matrix[i][0], i, 0);
			q.offer(tuple);
		}
		while (true) {
			Tuple t = q.poll();
			if (--k == 0) {
				return t.data;
			}
			if (t.col + 1 == matrix[0].length) { // Reached maximum column in the row. 
				continue;
			}
			q.offer(new Tuple(matrix[t.row][t.col + 1], t.row, t.col + 1));
		}

	}

	class Tuple implements Comparable<Tuple> {
		int data;
		int row;
		int col;

		public Tuple(int data, int row, int col) {
			this.data = data;
			this.row = row;
			this.col = col;
		}

		public int compareTo(Tuple t2) {
			return data - t2.data;
		}
	}

	public static void main(String[] args) {
		KthSmallestElementInASortedMatrix k = new KthSmallestElementInASortedMatrix();
		System.out.println(k.kthSmallest(new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } }, 8));

	}

}
