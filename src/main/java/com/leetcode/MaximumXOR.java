package com.leetcode;

public class MaximumXOR {

  public static void main(String[] args) {
    int[] nums = {3, 10, 5, 25, 2, 8};
    System.out.println(new MaximumXOR().findMaximumXOR(nums));
  }

  public int findMaximumXOR(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return 0;
    }
    if (n == 2) {
      return nums[0] ^ nums[1];
    }
    Trie trie = new Trie();
    trie.insert(nums);
    int max = 0;
    for (int num : nums) {
      int res = 0;
      TrieNode node = trie.root;
      for (int i = 31; i >= 0; i--) {
        int requiredBit = 1 - ((num >> i) & 1);
        if (node.child[requiredBit] != null) {
          res |= (1 << i);
          node = node.child[requiredBit];
        } else {
          node = node.child[1 - requiredBit];
        }
      }
      max = Math.max(max, res);
    }
    return max;
  }

  static class TrieNode {

    TrieNode[] child = new TrieNode[2];
  }

  static class Trie {

    TrieNode root = new TrieNode();

    public void insert(int[] nums) {
      for (int num : nums) {
        TrieNode current = root;
        for (int i = 31; i >= 0; i--) {
          int bit = (num >> i) & 1;
          if (current.child[bit] == null) {
            current.child[bit] = new TrieNode();
          }
          current = current.child[bit];
        }
      }
    }
  }
}