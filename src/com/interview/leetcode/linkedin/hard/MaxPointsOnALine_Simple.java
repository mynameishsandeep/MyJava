package com.interview.leetcode.linkedin.hard;

import java.util.HashMap;

import com.interview.leetcode.Point;

/*
 * Slope Formula =  line = (y2 - y1) / (x2 - x1).
 * 
 * 1) A slope is a line which cuts 2 points.
 * 2) Take a point and calculate slope with all other points. So. it will be n*n operation.
 * 3) Do step2 for all the points.
 * 4) Whichever has the most point wins.
 */
public class MaxPointsOnALine_Simple {

	public int maxPoints(Point[] points) {
		HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
		if (points.length <= 0)
			return 0;
		if (points.length <= 2)
			return points.length;
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			
			for (int j = 0; j < points.length; j++) {
				if (j != i) {
					// Apply slope formula
					double k = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
					hm.put(k, hm.getOrDefault(k, 1) + 1 );
					System.out.println(hm);
					result = Math.max(result, hm.get(k));
				}
			}
			hm.clear();
		}
		return result;
	}

	public static void main(String[] args) {
		MaxPointsOnALine_Simple m = new MaxPointsOnALine_Simple();
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 2);
		Point p3 = new Point(1, 3);
		Point p4 = new Point(2, 1);
		Point p5 = new Point(3, 1);
		Point p6 = new Point(2, 2);
		Point p7 = new Point(3, 3);
		Point points[] = { p1, p2, p3, p4, p5, p6, p7 };// 3

		System.out.println(m.maxPoints(points));
	}
}
