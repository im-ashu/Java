package com.datastructure.backtracking;

public class SolveSudoku {

  public static void print(
      int[][] board, int N) {

    // We got the answer, just print it
    for (int r = 0; r < N; r++) {
      for (int d = 0; d < N; d++) {
        System.out.print(board[r][d]);
        System.out.print(" ");
      }
      System.out.print("\n");

      if ((r + 1) % (int) Math.sqrt(N) == 0) {
        System.out.print("");
      }
    }
  }

  public static void main(String[] args) {
    int[][] board = new int[][]{
        {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };
    int N = board.length;

    if (solveSudoku(board, N)) {
      // print solution
      print(board, N);
    } else {
      System.out.println("No solution");
    }
  }

  private static boolean solveSudoku(int[][] board, int n) {
    int row = -1;
    int col = -1;
    boolean isEmpty = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 0) {
          row = i;
          col = j;
          isEmpty = false;
          break;
        }
      }
      if (!isEmpty) {
        break;
      }
    }
    if (isEmpty) {
      return true;
    }

    for (int num = 1; num <= 9; num++) {
      if (isSafe(board, row, col, num)) {
        board[row][col] = num;
        if (solveSudoku(board, n)) {
          return true;
        }
        board[row][col] = 0;
      }
    }
    return false;
  }

  private static boolean isSafe(int[][] board, int row, int col, int num) {
    int n = board.length;
    for (int i = 0; i < n; i++) {
      if (board[row][i] == num) {
        return false;
      }
    }
    for (int i = 0; i < n; i++) {
      if (board[i][col] == num) {
        return false;
      }
    }
    int sqrt = (int) Math.sqrt(n);
    int rowBoxStart = row - row % sqrt;
    int colBoxStart = col - col % sqrt;
    for (int i = rowBoxStart; i < rowBoxStart + sqrt; i++) {
      for (int j = colBoxStart; j < colBoxStart + sqrt; j++) {
        if (board[i][j] == num) {
          return false;
        }
      }
    }
    return true;
  }
}