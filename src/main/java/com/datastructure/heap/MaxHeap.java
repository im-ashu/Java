package com.datastructure.heap;

public class MaxHeap {

  int[] heapArray;
  int heapSize;
  int capacity;

  public MaxHeap(int[] array, int size) {
    heapArray = array;
    heapSize = size;
    int i = (size - 1) / 2;
    while (i >= 0) {
      maxHeapify(i);
      i--;
    }
  }

  int left(int i) {
    return (2 * i + 1);
  }

  int right(int i) {
    return (2 * i + 2);
  }

  int parent(int i) {
    return ((i - 1) / 2);
  }

  public int getMax() {
    return heapArray[0];
  }

  public void replaceMax(int x) {
    heapArray[0] = x;
    maxHeapify(0);
  }

  int extractMax() {
    if (heapSize == 0) {
      return Integer.MIN_VALUE;
    }
    int root = heapArray[0];
    if (heapSize > 1) {
      heapArray[0] = heapArray[heapSize - 1];
      maxHeapify(0);
    }
    heapSize--;
    return root;
  }

  void maxHeapify(int i) {
    int left = left(i);
    int right = right(i);
    int largest = i;
    if (left < heapSize && heapArray[left] > heapArray[i]) {
      largest = left;
    }
    if (right < heapSize && heapArray[right] > heapArray[largest]) {
      largest = right;
    }
    if (largest != i) {
      int temp = heapArray[i];
      heapArray[i] = heapArray[largest];
      heapArray[largest] = temp;
      maxHeapify(largest);
    }
  }

}