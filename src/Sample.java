class Sample {

  private int count(int[][] matrix, int midNumber) {
    int i = matrix.length - 1, j = 0;
    int c = 0;
    while (i >= 0 && j < matrix.length) {
      if (matrix[i][j] <= midNumber) {
        c += i + 1;
        j++;
      } else i--;
    }
    return c;
  }

  public int kthSmallest(int[][] matrix, int k) {
    int low = matrix[0][0], high = matrix[matrix.length - 1][matrix.length - 1];
    while (low < high) {
      int mid = low + ((high - low) / 2);
      int numberOfElementsLessThanMid = count(matrix, mid);
      if (numberOfElementsLessThanMid == k) {
        return high;
      } else if (numberOfElementsLessThanMid < k) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return 0;
  }
}
