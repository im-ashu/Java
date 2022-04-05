package com.leetcode;

public class AddBinary {

  public static void main(String[] args) {
    AddBinary addBinary = new AddBinary();
    String a = "1010", b = "1011";
    System.out.println(addBinary.addBinary(a, b));
  }

  public String addBinary(String a, String b) {
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    StringBuilder sum = new StringBuilder();

    while (i >= 0 || j >= 0 || carry > 0) {
      carry += i >= 0 ? a.charAt(i--) - '0' : 0;
      carry += j >= 0 ? b.charAt(j--) - '0' : 0;
      sum.insert(0, (carry % 2));
      carry >>= 1;
    }
    return sum.toString();
  }

}
