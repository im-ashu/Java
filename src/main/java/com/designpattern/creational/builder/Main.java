package com.designpattern.creational.builder;

public class Main {

  public static void main(String[] args) {
    User ashu = new User.UserBuilder("Ashu", "Bansal").setAge(25).build();
    User anu = new User.UserBuilder("Anu", "Bansal").build();
    System.out.println(ashu);
    System.out.println(anu);
  }
}
