package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllRepeatingThriceExceptOne {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 1, 2, 3));
    System.out.println(uniqueNumber(list));
  }

  private static int uniqueNumber(List<Integer> list) {
    int tn = -1;
    int tn1 = 0;
    int tn2 = 0;
    for (Integer num : list) {
      int cwtn = tn & num;
      int cwtn1 = tn1 & num;
      int cwtn2 = tn2 & num;

      tn = tn & (~cwtn);
      tn1 = tn1 | cwtn;

      tn1 = tn1 & (~cwtn1);
      tn2 = tn2 | cwtn1;

      tn2 = tn2 & (~cwtn2);
      tn = tn | cwtn2;
    }
    return tn1;
  }
}