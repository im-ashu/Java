package com.datastructure.backtracking;

public class NQueenProblem {

  public static void main(String[] args) {
    int[][] board = {{0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}};

    if (!solveNQUtil(board, 0)) {
      System.out.println("Solution does not exist");
    }

    printSolution(board);
  }

  private static void printSolution(int[][] board) {
    int N = board.length;
    for (int[] ints : board) {
      for (int j = 0; j < N; j++) {
        System.out.print(ints[j] + " ");
      }
      System.out.println();
    }
  }

  private static boolean solveNQUtil(int[][] board, int col) {
    int N = board.length;
    if (col >= N) {
      return true;
    }
    for (int i = 0; i < N; i++) {
      if (isSafe(board, i, col)) {
        board[i][col] = 1;
        if (solveNQUtil(board, col + 1)) {
          return true;
        }
        board[i][col] = 0;
      }
    }
    return false;
  }

  private static boolean isSafe(int[][] board, int row, int col) {
    int N = board.length;

    //same row
    for (int i = 0; i < N; i++) {
      if (board[row][i] == 1) {
        return false;
      }
    }

    //upper diagonal left side
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    //lower diagonal left side
    for (int i = row, j = col; i < N && j >= 0; i++, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }
    return true;
  }
}