package com.leetcode;

public class GameOfLife {

  public static void main(String[] args) {
    int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
    new GameOfLife().gameOfLife(board);
    for (int[] ints : board) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(ints[j] + " ");
      }
      System.out.println();
    }
  }

  public void gameOfLife(int[][] board) {
    int row = board.length;
    int col = board[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        int lives = aliveNeighbors(board, i, j);
        if (board[i][j] == 1) {
          if (lives == 2 || lives == 3) {
            board[i][j] = 3;
          }
        } else {
          if (lives == 3) {
            board[i][j] = 2;
          }
        }
      }
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        board[i][j] >>= 1;
      }
    }
  }

  private int aliveNeighbors(int[][] board, int row, int col) {
    int neighbors = 0;
    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = col - 1; j <= col + 1; j++) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
          neighbors += board[i][j] & 1;
        }
      }
    }
    neighbors -= board[row][col] & 1;
    return neighbors;
  }
}