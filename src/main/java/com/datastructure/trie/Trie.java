package com.datastructure.trie;

import java.util.HashMap;

public class Trie {

  private final TrieNode root;

  public Trie() {
    root = new TrieNode((char) 0);
  }

  public static void main(String[] args) {
    // Input keys (use only 'a' through 'z' and lower case)
    String[] keys = {"the", "a", "there", "answer", "any",
        "by", "bye", "their"};

    String[] output = {"Not present in trie", "Present in trie"};

    Trie trie = new Trie();

    // Construct trie
    int i;
   for (i = 0; i < keys.length; i++) {
    trie.insert(keys[i]);
   }

    // Search for different keys
   if (trie.search("these")) {
    System.out.println("these --- " + output[1]);
   } else {
    System.out.println("these --- " + output[0]);
   }

    trie.remove(trie.root, "the", 0);

   if (trie.search("the")) {
    System.out.println("the --- " + output[1]);
   } else {
    System.out.println("the --- " + output[0]);
   }

   if (trie.search("their")) {
    System.out.println("their --- " + output[1]);
   } else {
    System.out.println("their --- " + output[0]);
   }

   if (trie.search("thaw")) {
    System.out.println("thaw --- " + output[1]);
   } else {
    System.out.println("thaw --- " + output[0]);
   }

  }

  public void insert(String word) {
    int length = word.length();
    TrieNode traverse = root;
    for (int i = 0; i < length; i++) {
      char c = word.charAt(i);
      HashMap<Character, TrieNode> children = traverse.getChildren();
      children.putIfAbsent(c, new TrieNode(c));
      traverse = children.get(c);
    }
    traverse.setIsEnd(true);
  }

  public boolean search(String word) {
    int length = word.length();
    TrieNode traverse = root;
    for (int i = 0; i < length; i++) {
      char c = word.charAt(i);
      HashMap<Character, TrieNode> children = traverse.getChildren();
      if (children.containsKey(c)) {
        traverse = children.get(c);
      } else {
        return false;
      }
    }
    return traverse.isEnd();
  }

  public TrieNode remove(TrieNode root, String word, int depth) {
    if (root == null) {
      return null;
    }
    if (depth == word.length()) {
      if (root.isEnd()) {
        root.setIsEnd(false);
      }
      if (isEmpty(root)) {
        root = null;
      }
      return root;
    }
    char ch = word.charAt(depth);
    root.getChildren().put(ch, remove(root.getChildren().get(ch), word, depth + 1));
    if (isEmpty(root) && !root.isEnd()) {
      return null;
    }
    return root;
  }

  private boolean isEmpty(TrieNode root) {
    return root.getChildren().keySet() == null;
  }
}