package com.designpattern.structural.filter;

import java.util.Set;

public interface Criteria {

  Set<Person> meetCriteria(Set<Person> people);
}
