package com.interview.leetcode.google.hard;

import com.interview.leetcode.Robot;

/*
* https://leetcode.com/problems/robot-room-cleaner/

Ex:
[[1,1],[1,1]]
1
1

For the above input, cleanRoom() cleans all positions.

*/
public class RobotRoomCleanerUnderstanding {

  Robot robot;

  public void cleanRoom(Robot robot) {
    this.robot = robot;
    cleanRoom();
  }

  private void cleanRoom() {
    robot.clean();
    robot.move();
    robot.clean();
    robot.turnLeft();
    robot.move();
    robot.clean();
    robot.turnLeft();
    robot.move();
    robot.clean();
  }
}
