package com.datastructure.heap;

public class MinHeap {

  public int[] heapArray;
  int heapSize;
  int capacity;
  int DEFAULT_CAPACITY = 50;

  public MinHeap(int[] a, int n) {
    capacity = DEFAULT_CAPACITY;
    heapArray = new int[capacity];
    System.arraycopy(a, 0, heapArray, 0, a.length);
    // heapArray = a;
    heapSize = n;
    int i = (n - 1) / 2;
    while (i >= 0) {
      heapify(i);
      i--;
    }
  }

  int left(int i) {
    return 2 * i + 1;
  }

  int right(int i) {
    return 2 * i + 2;
  }

  int parent(int i) {
    return (i - 1) / 2;
  }

  public int extractMin() {
    if (heapSize == 0) {
      return Integer.MAX_VALUE;
    }
    int root = heapArray[0];
    if (heapSize > 1) {
      removeAt(0);
      heapify(0);
    }
    heapSize--;
    return root;
  }

  public int getMin() {
    if (heapSize == 0) {
      return Integer.MAX_VALUE;
    }
    return heapArray[0];
  }

  void heapify(int i) {
    int left = left(i);
    int right = right(i);
    int smallest = i;
    if (left < heapSize && heapArray[left] < heapArray[i]) {
      smallest = left;
    }
    if (right < heapSize && heapArray[right] < heapArray[smallest]) {
      smallest = right;
    }
    if (smallest != i) {
      int temp = heapArray[smallest];
      heapArray[smallest] = heapArray[i];
      heapArray[i] = temp;
      heapify(smallest);
    }
  }

  public void insert(int data) {
    heapArray[heapSize] = data;
    swim(heapSize);
    heapSize++;
  }

  private void swim(int i) {
    int parent = parent(i);
    if (parent >= 0) {
      while (i > 0 && heapArray[i] < heapArray[parent]) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[parent];
        heapArray[parent] = temp;
        i = parent;
        parent = parent(i);
      }
    }
  }

  public boolean remove(int data) {
    for (int i = 0; i < heapSize; i++) {
      if (heapArray[i] == data) {
        removeAt(i);
        return true;
      }
    }
    return false;
  }

  private void removeAt(int i) {
    if (i < heapSize) {
      heapArray[i] = heapArray[heapSize - 1];
      heapArray[heapSize - 1] = -1;
      heapSize--;
      heapify(i);
      swim(i);
    }
  }
}