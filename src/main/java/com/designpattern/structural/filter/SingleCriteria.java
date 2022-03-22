package com.designpattern.structural.filter;

import java.util.Set;
import java.util.stream.Collectors;

public class SingleCriteria implements Criteria {

  @Override
  public Set<Person> meetCriteria(Set<Person> people) {
    return people.stream().filter(person -> person.getMaritalStatus().equals(MaritalStatus.SINGLE))
        .collect(Collectors.toSet());
  }
}
