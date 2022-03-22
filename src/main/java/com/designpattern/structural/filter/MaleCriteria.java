package com.designpattern.structural.filter;

import java.util.Set;
import java.util.stream.Collectors;

public class MaleCriteria implements Criteria {

  @Override
  public Set<Person> meetCriteria(Set<Person> people) {
    return people.stream().filter(person -> person.getGender().equals(Gender.MALE)).collect(
        Collectors.toSet());
  }
}
