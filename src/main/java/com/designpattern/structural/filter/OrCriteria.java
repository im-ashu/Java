package com.designpattern.structural.filter;

import java.util.Set;

public class OrCriteria implements Criteria {

  private final Criteria criteria;
  private final Criteria otherCriteria;

  public OrCriteria(Criteria criteria, Criteria otherCriteria) {
    this.criteria = criteria;
    this.otherCriteria = otherCriteria;
  }

  @Override
  public Set<Person> meetCriteria(Set<Person> people) {
    Set<Person> people1 = criteria.meetCriteria(people);
    Set<Person> people2 = otherCriteria.meetCriteria(people);
    people1.addAll(people2);
    return people1;
  }
}
