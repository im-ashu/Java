package com.leetcode;

public class SudokuSolver {

  public static void main(String[] args) {
    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    new SudokuSolver().solveSudoku(board);

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void solveSudoku(char[][] board) {
    solveSudokuUtil(board);
  }

  private boolean solveSudokuUtil(char[][] board) {
    int n = board.length;
    int row = -1;
    int col = -1;
    boolean emptyCell = true;
    for (int i = 0; i < n && emptyCell; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == '.') {
          row = i;
          col = j;
          emptyCell = false;
          break;
        }
      }
    }
    if (emptyCell) {
      return true;
    }

    for (int i = 1; i <= board.length; i++) {
      if (isSafe(board, row, col, i)) {
        board[row][col] = (char) ('0' + i);
        if (solveSudokuUtil(board)) {
          return true;
        }
        board[row][col] = '.';
      }
    }
    return false;
  }

  private boolean isSafe(char[][] board, int row, int col, int num) {
    for (char[] chars : board) {
      if (chars[col] == (char) ('0' + num)) {
        return false;
      }
    }
    for (int i = 0; i < board.length; i++) {
      if (board[row][i] == (char) ('0' + num)) {
        return false;
      }
    }
    int sqrt = (int) Math.sqrt(board.length);
    int rowBoxStart = row - row % sqrt;
    int colBoxStart = col - col % sqrt;
    for (int i = rowBoxStart; i < rowBoxStart + sqrt; i++) {
      for (int j = colBoxStart; j < colBoxStart + sqrt; j++) {
        if (board[i][j] == (char) ('0' + num)) {
          return false;
        }
      }
    }
    return true;
  }

}
