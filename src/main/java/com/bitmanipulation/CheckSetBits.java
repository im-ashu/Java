package com.bitmanipulation;

public class CheckSetBits {

  public static void main(String[] args) {
    System.out.println(isBitSet(7));
  }

  public static int isBitSet(int N) {
    int numberOfBits = (int) (Math.floor(Math.log(N) / Math.log(2))) + 1;
    return (((1 << numberOfBits) - 1) ^ N) ^ 1;
    //code here
 /*if (N == 0)
 return 0;
 if (((N + 1) & N) == 0)
 return 1;
 return 0;*/
  }
}