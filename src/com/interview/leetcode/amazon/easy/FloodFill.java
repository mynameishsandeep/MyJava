package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/flood-fill/
 *
 * 1) Go in all the 4 direction, if oldColor is present in that index. Update the index.
 * 2) One key point to note is, if oldColor and currentColor is same. Then recursion will go
 * infinite. Solution wise no change is needed. So just return input itself.
 * =====I forget this point and coded with isVisited. Still that worked. But isVisited logic is not needed here======
 */
public class FloodFill {

  public void floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
    image[sr][sc] = newColor;
    // left
    if (sc != 0 && image[sr][sc - 1] == oldColor) {
      floodFill(image, sr, sc - 1, newColor, oldColor);
    }
    // right
    if (sc + 1 < image[0].length && image[sr][sc + 1] == oldColor) {
      floodFill(image, sr, sc + 1, newColor, oldColor);
    }
    // top
    if (sr != 0 && image[sr - 1][sc] == oldColor) {
      floodFill(image, sr - 1, sc, newColor, oldColor);
    }
    // Bottom
    if (sr + 1 < image.length && image[sr + 1][sc] == oldColor) {
      floodFill(image, sr + 1, sc, newColor, oldColor);
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image[sr][sc] != newColor) {
      floodFill(image, sr, sc, newColor, image[sr][sc]);
    }
    return image;
  }
}
