package com.datastructure.binarysearch;

public class NextGreatestAlphabet {

  public static void main(String[] args) {
    char[] letters = {'A', 'r', 'z'};
    char K = 'A';
    char result = nextGreatestAlphabet(letters, K);

    // Function call
    System.out.println(result);
  }

  private static char nextGreatestAlphabet(char[] letters, char k) {
    int n = letters.length;
    char res = 0;
    if (k >= letters[n - 1]) {
      return res;
    }
    int start = 0, end = n - 1;
    while (start <= end) {
      int mid = start + ((end - start) >> 1);
      if (letters[mid] > k) {
        res = letters[mid];
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return res;

  }
}