package com.datastructure.trie;

import java.util.HashMap;

public class TrieNode {

  private final char value;
  private final HashMap<Character, TrieNode> children;
  private boolean bIsEnd;

  public TrieNode(char ch) {
    value = ch;
    children = new HashMap<>();
    bIsEnd = false;
  }

  public char getValue() {
    return value;
  }

  public HashMap<Character, TrieNode> getChildren() {
    return children;
  }

  public boolean isEnd() {
    return bIsEnd;
  }

  public void setIsEnd(boolean bIsEnd) {
    this.bIsEnd = bIsEnd;
  }
}