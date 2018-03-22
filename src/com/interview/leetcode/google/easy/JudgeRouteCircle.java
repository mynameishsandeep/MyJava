package com.interview.leetcode.google.easy;

/**
 * https://leetcode.com/problems/judge-route-circle/description/
 *
 *The move sequence is represented by a string. And each move is represent by a character. 
 *The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or 
 *false representing whether the robot makes a circle.
 *
	Input: "UD"
	Output: true
	
	Input: "LL"
	Output: false
 */
public class JudgeRouteCircle {

	public static boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;

		for (Character ch : moves.toCharArray()) {
			switch (ch) {
			case 'L':
				x--;
				break;
			case 'R':
				x++;
				break;
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			default:
				break;
			}
		}
		return (x == 0 && y == 0);
	}

	public static void main(String[] args) {
		System.out.println(judgeCircle("UD"));
	}
}
