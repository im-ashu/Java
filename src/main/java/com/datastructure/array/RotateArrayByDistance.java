package com.datastructure.array;

import java.util.Arrays;

public class RotateArrayByDistance {

  public static void main(String[] args) {
    RotateArrayByDistance rotateArrayByDistance = new RotateArrayByDistance();
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
//    List<Integer> list = Arrays.asList(arr);
//    Collections.rotate(list, 2);
//    list.toArray(arr);
//    Arrays.stream(arr).forEach(integer -> System.out.print(integer+ " "));
    rotateArrayByDistance.leftRotate(arr, 3, arr.length);
    rotateArrayByDistance.printArray(arr);
    System.out.println();
    rotateArrayByDistance.rightRotate(arr, 3, arr.length);
    rotateArrayByDistance.rightRotate(arr, 3, arr.length);
    rotateArrayByDistance.printArray(arr);
  }

  private void printArray(int[] arr) {
    Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
  }

  private void leftRotate(int[] arr, int distance, int length) {

    distance = distance % length;
    /*
     * Solution 1 :
     * Rotate One by One
     * Time Complexity : O(d * n)
     * Auxiliary Space : O(1)
     * */
//    for (int i = 0; i < distance; i++) {
//      leftRotateByOne(arr, length);
//    }

    /*
     * Solution 2 :
     * Rotate by GCD
     * Time Complexity : O(n)
     * Auxiliary Space : O(1)
     * */
//    int i, j, k, temp;
//    int gcd = gcd(distance, length);
//    for (i = 0; i < gcd; i++) {
//      j = i;
//      temp = arr[i];
//      while (true) {
//        k = j + distance;
//        if (k >= length) {
//          k = k - length;
//        }
//        if (k == i) {
//          break;
//        }
//        arr[j] = arr[k];
//        j = k;
//      }
//      arr[j] = temp;
//    }

    /*
     * Solution 3 :
     * Time Complexity : O(n)
     * Auxiliary Space : O(1)
     * */
    reverseArray(arr, 0, distance - 1);
    reverseArray(arr, distance, length - 1);
    reverseArray(arr, 0, length - 1);
  }

  private void rightRotate(int[] arr, int distance, int length) {
    reverseArray(arr, 0, length - 1);
    reverseArray(arr, 0, distance - 1);
    reverseArray(arr, distance, length - 1);
  }

  private void reverseArray(int[] arr, int start, int end) {
    int temp;
    while (start < end) {
      temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  private int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

  private void leftRotateByOne(int[] arr, int length) {
    int i, temp;
    temp = arr[0];
    for (i = 0; i < length - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[i] = temp;
  }
}
