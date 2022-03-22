package com.designpattern.structural.filter;

import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Set<Person> people = new HashSet<>();
    people.add(new Person("Robert", Gender.MALE, MaritalStatus.SINGLE));
    people.add(new Person("John", Gender.MALE, MaritalStatus.MARRIED));
    people.add(new Person("Laura", Gender.FEMALE, MaritalStatus.MARRIED));
    people.add(new Person("Diana", Gender.FEMALE, MaritalStatus.SINGLE));
    people.add(new Person("Mike", Gender.MALE, MaritalStatus.SINGLE));
    people.add(new Person("Bobby", Gender.MALE, MaritalStatus.SINGLE));

    Criteria male = new MaleCriteria();
    Criteria female = new FemaleCriteria();
    Criteria single = new SingleCriteria();
    Criteria maleAndSingle = new AndCriteria(male, single);
    Criteria femaleOrSingle = new OrCriteria(female, single);

    printPersons(male.meetCriteria(people));

    female.meetCriteria(people).forEach(System.out::println);
    single.meetCriteria(people).forEach(System.out::println);
    maleAndSingle.meetCriteria(people).forEach(System.out::println);
    femaleOrSingle.meetCriteria(people).forEach(System.out::println);
    femaleOrSingle.meetCriteria(people).forEach(System.out::println);

  }

  public static void printPersons(Set<Person> persons) {
    persons.forEach(System.out::println);
  }
}
