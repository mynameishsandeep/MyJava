package com.interview.leetcode.google.hard;

import java.util.HashSet;
import java.util.Set;

import com.interview.leetcode.Robot;

/*
* https://leetcode.com/problems/robot-room-cleaner/

=======Conditions:============
 // returns true if next cell is open and robot moves into the cell.
 // returns false if next cell is obstacle and robot stays on the current cell.
 boolean move();

 // Robot will stay on the same cell after calling turnLeft/turnRight. Each turn will be 90 degrees.
 void turnLeft();  // Rotate anti-clockwise 90 degree
 void turnRight(); // Rotate clockwise 90 degree

 // Clean the current cell.
 void clean();

 0 means the cell is blocked, while 1 means the cell is accessible.

 The initial direction of the robot will be facing up.
 ============Assumptions========================================
1) We don't know the grid size and where robot stands in grid.
2) So where-ever robot stands we mark them as 0,0.. This is to make sure we will visit that point again.

===============General Logic===========
1) From the point where robot stands.
2) First clean it.
3) Spawn in 4 directions.
4) Spawn has 1 issue. If we call move()... Then robot moves if there is no block. So we have to
move robot back(backtrack) to spawn in next direction.
5) Once brought back to same location using backtrack, move robot left or right to spawn in next direction.
=================Why we need direction? is yet to be analyzed=======

*/
public class RobotRoomCleaner {
  private static final int[][] dirs =
      new int[][] {
        {-1, 0}, // up (0)
        {0, 1}, // right (1)
        {1, 0}, // down (2)
        {0, -1} // left (3)
      };
  Robot r;
  Set<String> s = new HashSet<>();

  public void cleanRoom(Robot robot) {
    r = robot;
    cleanRoom(0, 0, 0);
  }

  private void cleanRoom(int direction, int x, int y) {
    String t = x + "->" + y;
    // if I was already here, return.
    if (s.contains(t)) return;
    s.add(t);
    // clean current position
    r.clean();

    // for each one of the directions
    for (int i = 0; i < 4; i++) {
      if (r.move()) {
        int nextDirection = (direction + i) % 4;
        // if I was able to move one, keep going down the rabbit hole..
        cleanRoom(nextDirection, x + dirs[nextDirection][0], y + dirs[nextDirection][1]);
        // After returning from the rabbit hole, go back to where I started at and adjust my
        // position back to what it was or "backtracking"
        r.turnLeft();
        r.turnLeft();
        r.move();
        r.turnLeft();
        r.turnLeft();
      }
      // try turning to the next direction
      r.turnLeft(); // r.turnRight both work
    }
  }
}
