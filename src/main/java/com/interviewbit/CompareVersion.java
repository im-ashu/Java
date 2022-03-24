package com.interviewbit;

public class CompareVersion {

  public static void main(String[] args) {
    String A = "01";
    String B = "5.168";
    System.out.println(compareVersion(A, B));
  }

  public static int compareVersion(String A, String B) {
    final String[] splitA = A.split("\\.");
    final String[] splitB = B.split("\\.");
    int len1 = splitA.length;
    int len2 = splitB.length;
    int i = 0, j = 0;
    while (i < len1 || j < len2) {
      String x = "";
      String y = "";
      if (i < len1) {
        if (splitA[i].charAt(0) == '0') {
          int len = splitA[i].length();
          int k = 0;
          while (k < len && splitA[i].charAt(k) == '0') {
            k++;
          }
          x += splitA[i].substring(k);
        } else {
          x = splitA[i];
        }
      }
      if (j < len2) {
        if (splitB[j].charAt(0) == '0') {
          int len = splitB[j].length();
          int k = 0;
          while (k < len && splitB[j].charAt(k) == '0') {
            k++;
          }
          y += splitB[j].substring(k);
        } else {
          y = splitB[j];
        }
      }
      int res = compareSubstring(x, y);
      if (res != 0) {
        return res;
      }
      i++;
      j++;
    }
    return 0;
  }

  private static int compareSubstring(String x, String y) {
    int len1 = x.length();
    int len2 = y.length();
    if (len1 > len2) {
      return 1;
    } else if (len2 > len1) {
      return -1;
    }
    int res = x.compareTo(y);
    if (res > 0) {
      return 1;
    } else if (res < 0) {
      return -1;
    }
    return 0;
  }
}