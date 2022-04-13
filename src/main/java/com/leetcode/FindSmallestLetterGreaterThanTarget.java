package com.leetcode;

public class FindSmallestLetterGreaterThanTarget {

  public static void main(String[] args) {
    FindSmallestLetterGreaterThanTarget findSmallestLetterGreaterThanTarget = new FindSmallestLetterGreaterThanTarget();
    char[] letters = {'c', 'f', 'j'};
    char target = 'd';
    System.out.println(findSmallestLetterGreaterThanTarget.nextGreatestLetter(letters, target));
  }

  public char nextGreatestLetter(char[] letters, char target) {
    int low = 0;
    int high = letters.length - 1;
    char res = letters[0];
    while (low <= high) {
      int mid = low + ((high - low) >> 1);
      if (letters[mid] > target) {
        res = letters[mid];
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return res;
  }
}
