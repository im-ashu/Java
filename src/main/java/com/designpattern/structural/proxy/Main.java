package com.designpattern.structural.proxy;

public class Main {

  public static void main(String[] args) {
    Image image = new ProxyImage("sachin.jpg");
    image.display();
    image.display();
  }

}
