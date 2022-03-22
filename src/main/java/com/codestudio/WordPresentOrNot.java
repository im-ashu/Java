package com.codestudio;

public class WordPresentOrNot {

  public static void main(String[] args) {
    String s = "coding is fun";
    String w = "not";
    System.out.println(findWord(s, w));
  }

  public static boolean findWord(String s, String w) {
    // Write your code here.
    Trie trie = new Trie();
    String[] words = s.split(" ");
    for (String word : words) {
      trie.insert(word);
    }
    return trie.search(w);
  }

  static class TrieNode {

    TrieNode[] child = new TrieNode[26];
    boolean isEnd;
  }

  static class Trie {

    TrieNode root = new TrieNode();

    public void insert(String s) {
      TrieNode current = root;
      for (char c : s.toCharArray()) {
        if (current.child[c - 'a'] == null) {
          current.child[c - 'a'] = new TrieNode();
        }
        current = current.child[c - 'a'];
      }
      current.isEnd = true;
    }

    public boolean search(String w) {
      TrieNode current = root;
      for (char c : w.toCharArray()) {
        if (current.child[c - 'a'] == null) {
          return false;
        }
        current = current.child[c - 'a'];
      }
      return current.isEnd;
    }
  }
}