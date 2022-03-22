package com.hackerrank.java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class JavaBigDecimal {

  public static void main(String[] args) {
    //Input
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] s = new String[n + 2];
    for (int i = 0; i < n; i++) {
      s[i] = sc.next();
    }
    sc.close();

    //Write your code here
    Arrays.sort(s, 0, n, Collections.reverseOrder((String str1, String str2) -> {
      BigDecimal dec1 = new BigDecimal(str1);
      BigDecimal dec2 = new BigDecimal(str2);
      return dec1.compareTo(dec2);
    }));

    //Output
    for (int i = 0; i < n; i++) {
      System.out.println(s[i]);
    }
  }
}