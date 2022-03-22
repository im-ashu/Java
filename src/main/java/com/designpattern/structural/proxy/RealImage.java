package com.designpattern.structural.proxy;

public class RealImage implements Image {

  private final String filename;

  public RealImage(String filename) {
    this.filename = filename;
    loadFileFromDisk(filename);
  }

  private void loadFileFromDisk(String filename) {
    System.out.println("Loading File [" + filename + "] from Disk");
  }

  @Override
  public void display() {
    System.out.println("Displaying File [" + filename + "]");
  }
}
