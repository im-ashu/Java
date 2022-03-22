package com.designpattern.creational.builder;

public class User {

  private final String firstName;
  private final String lastName;
  private final int age;
  private final String passport;

  private User(UserBuilder userBuilder) {
    this.firstName = userBuilder.firstName;
    this.lastName = userBuilder.lastName;
    this.age = userBuilder.age;
    this.passport = userBuilder.passport;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public String getPassport() {
    return passport;
  }

  @Override
  public String toString() {
    return "User{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        ", passport='" + passport + '\'' +
        '}';
  }

  public static class UserBuilder {

    private final String firstName;
    private final String lastName;
    private int age;
    private String passport;

    public UserBuilder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public UserBuilder setAge(int age) {
      this.age = age;
      return this;
    }

    public UserBuilder setPassport(String passport) {
      this.passport = passport;
      return this;
    }

    public User build() {
      return new User(this);
    }
  }
}
