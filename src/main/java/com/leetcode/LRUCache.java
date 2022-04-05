package com.leetcode;

import java.util.HashMap;

public class LRUCache {

  private static class DoublyLinkedList {

    DLLNode head;
    DLLNode tail;

    public DoublyLinkedList() {
      head = new DLLNode(-1, -1);
      tail = new DLLNode(-1, -1);
      head.next = tail;
      tail.prev = head;
    }

    public void remove(DLLNode nodeToRemove) {
      DLLNode nodeToRemovePrev = nodeToRemove.prev;
      DLLNode nodeToRemoveNext = nodeToRemove.next;
      nodeToRemovePrev.next = nodeToRemoveNext;
      nodeToRemoveNext.prev = nodeToRemovePrev;
      nodeToRemove.prev = null;
      nodeToRemove.next = null;
    }

    public void insert(DLLNode node) {
      DLLNode headNext = head.next;
      head.next = node;
      headNext.prev = node;
      node.prev = head;
      node.next = headNext;
    }
  }

  private static class DLLNode {

    DLLNode prev;
    DLLNode next;
    int key;
    int value;

    public DLLNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int capacity;
  private final DoublyLinkedList linkedList;
  private final HashMap<Integer, DLLNode> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    linkedList = new DoublyLinkedList();
    cache = new HashMap<>();
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    DLLNode node = cache.get(key);
    linkedList.remove(node);
    linkedList.insert(node);

    return node.value;
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      DLLNode node = cache.get(key);
      linkedList.remove(node);
      cache.remove(node.key);
    }
    if (cache.size() >= capacity) {
      DLLNode removeLRU = linkedList.tail.prev;
      cache.remove(removeLRU.key);
      linkedList.remove(removeLRU);
    }
    DLLNode node = new DLLNode(key, value);
    cache.put(key, node);
    linkedList.insert(node);
  }

  public static void main(String[] args) {
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    System.out.println(lRUCache.get(1));    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    System.out.println(lRUCache.get(2));    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.put(4, 5); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    System.out.println(lRUCache.get(1));    // return -1 (not found)
    System.out.println(lRUCache.get(3));    // return 3
    System.out.println(lRUCache.get(4));    // return 4
  }
}
