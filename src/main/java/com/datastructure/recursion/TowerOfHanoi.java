package com.datastructure.recursion;

public class TowerOfHanoi {

  public static void main(String[] args) {
    int noOfDisk = 4;
    String sourceDisk = "Source";
    String destinationDisk = "Destination";
    String helperDisk = "Helper";
    solve(noOfDisk, sourceDisk, destinationDisk, helperDisk);

  }

  private static void solve(int noOfDisk, String sourceDisk, String destinationDisk,
      String helperDisk) {
    if (noOfDisk == 1) {
      System.out.println(
          "Moving Disk : " + noOfDisk + " From : " + sourceDisk + " To : " + destinationDisk);
      return;
    }
    solve(noOfDisk - 1, sourceDisk, helperDisk, destinationDisk);
    System.out.println(
        "Moving Disk : " + noOfDisk + " From : " + sourceDisk + " To : " + destinationDisk);
    solve(noOfDisk - 1, helperDisk, destinationDisk, sourceDisk);
  }
}