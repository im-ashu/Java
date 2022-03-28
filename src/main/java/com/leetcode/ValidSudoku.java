package com.leetcode;

public class ValidSudoku {

  public static void main(String[] args) {
    char[][] board = {
        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    System.out.println(new ValidSudoku().isValidSudoku(board));
  }

  public boolean isValidSudoku(char[][] board) {
    int n = board.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] != '.') {
          if (!valid(board, i, j)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private boolean valid(char[][] board, int row, int col) {
    char val = board[row][col];
    int n = board.length;
    for (int i = 0; i < n; i++) {
      if (i != row && board[i][col] == val) {
        return false;
      }
    }
    for (int j = 0; j < n; j++) {
      if (j != col && board[row][j] == val) {
        return false;
      }
    }
    int sqrt = (int) Math.sqrt(n);
    int rowBoxStart = row - row % sqrt;
    int colBoxStart = col - col % sqrt;
    for (int i = rowBoxStart; i < rowBoxStart + sqrt; i++) {
      for (int j = colBoxStart; j < colBoxStart + sqrt; j++) {
        if (i != row && j != col && board[i][j] == val) {
          return false;
        }
      }
    }
    return true;
  }
}
