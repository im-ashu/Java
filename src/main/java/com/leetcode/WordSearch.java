package com.leetcode;

import java.util.HashMap;

public class WordSearch {

  public static void main(String[] args) {
    WordSearch wordSearch = new WordSearch();
    char[][] board = {{'a'}, {'a'}};
    String word = "aa";
    System.out.println(wordSearch.exist(board, word));
  }

  public boolean exist(char[][] board, String word) {
    int tRow = board.length;
    int tCol = board[0].length;
    HashMap<Character, Integer> occurrencesMap = new HashMap<>();
    for (char ch : word.toCharArray()) {
      occurrencesMap.put(ch, occurrencesMap.getOrDefault(ch, 0) + 1);
    }
    int counter = occurrencesMap.size();
    for (char[] chars : board) {
      for (int j = 0; j < tCol; j++) {
        char ch = chars[j];
        if (occurrencesMap.containsKey(ch)) {
          occurrencesMap.put(ch, occurrencesMap.get(ch) - 1);
          if (occurrencesMap.get(ch) == 0) {
            counter--;
          }
        }
      }
    }
    if (counter > 0) {
      return false;
    }
    if (word.length() == 1) {
      return true;
    }
    boolean[][] visited = new boolean[tRow][tCol];
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    for (int i = 0; i < tRow; i++) {
      for (int j = 0; j < tCol; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (dfs(board, i, j, visited, 0, word, dir)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, int i, int j, boolean[][] visited, int k, String word,
      int[][] dir) {

    if (k == word.length()) {
      return true;
    }

    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]
        || k > word.length()) {
      return false;
    }

    if (word.charAt(k) != board[i][j]) {
      return false;
    }
    visited[i][j] = true;
    for (int[] ints : dir) {
      int x1 = ints[0];
      int y1 = ints[1];
      if (dfs(board, i + x1, j + y1, visited, k + 1, word, dir)) {
        return true;
      }
    }
    visited[i][j] = false;
    return false;
  }
}
