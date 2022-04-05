package com.leetcode;

public class PlusOne {

  public static void main(String[] args) {
    PlusOne plusOne = new PlusOne();
    int[] digits = {4, 9, 9, 9};
    int[] plusOne1 = plusOne.plusOne(digits);
    for (int e : plusOne1) {
      System.out.print(e + " ");
    }
    plusOne1 = plusOne.plusOneII(digits);
    System.out.println();
    for (int e : plusOne1) {
      System.out.print(e + " ");
    }
  }

  public int[] plusOne(int[] digits) {
    int n = digits.length;
    int[] ans = new int[n + 1];
    ans[n] = (digits[n - 1] + 1) % 10;
    int carry = (digits[n - 1] + 1) / 10;
    for (int i = n - 2; i >= 0; i--) {
      ans[i + 1] = (digits[i] + carry) % 10;
      carry = (digits[i] + carry) / 10;
    }
    if (carry == 1) {
      ans[0] = 1;
      return ans;
    }
    int[] ansCopy = new int[n];
    System.arraycopy(ans, 1, ansCopy, 0, n);
    return ansCopy;
  }

  public int[] plusOneII(int[] digits) {

    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    int[] newNumber = new int[n + 1];
    newNumber[0] = 1;
    return newNumber;
  }
}
