package com.stream;

public class Person {

  private final String name;
  private final int age;
  private final Gender gender;

  public Person(String name, int age, Gender gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "People{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", gender=" + gender +
        '}';
  }

  public Gender getGender() {
    return gender;
  }
}
