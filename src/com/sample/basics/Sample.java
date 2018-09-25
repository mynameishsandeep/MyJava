package com.sample.basics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Sample {

	int V;
	LinkedList<Integer> adj[];

	Sample(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void BFS(int s, int l) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(s);
		visited[s] = true;
		int level[] = new int[V];
		level[s] = 1;

		while (queue.size() != 0) {
			int current = queue.poll();
			Iterator<Integer> i = adj[current].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					queue.add(n);
					level[n] = level[current] + 1;
					visited[n] = true;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (level[i] == l) {
				++count;
			}
		}
		System.out.println(count);

	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Sample bsf = new Sample(n);
		for (int i = 0; i < n - 1; i++) {
			bsf.addEdge(in.nextInt() - 1, in.nextInt() - 1);
		}
		int level = in.nextInt();
		bsf.BFS(0, level);
	}
}
