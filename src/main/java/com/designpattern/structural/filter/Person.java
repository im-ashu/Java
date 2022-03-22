package com.designpattern.structural.filter;

import java.util.Objects;

public class Person {

  private final String name;
  private final Gender gender;
  private final MaritalStatus maritalStatus;

  public Person(String name, Gender gender,
      MaritalStatus maritalStatus) {
    this.name = name;
    this.gender = gender;
    this.maritalStatus = maritalStatus;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", gender=" + gender +
        ", maritalStatus=" + maritalStatus +
        '}';
  }

  public String getName() {
    return name;
  }

  public Gender getGender() {
    return gender;
  }

  public MaritalStatus getMaritalStatus() {
    return maritalStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(name, person.name) &&
        gender == person.gender &&
        maritalStatus == person.maritalStatus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, gender, maritalStatus);
  }
}
