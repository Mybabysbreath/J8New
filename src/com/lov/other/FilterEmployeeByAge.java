package com.lov.other;

import com.lov.entity.Employee;

public class FilterEmployeeByAge implements MyPredicate<Employee> {

	@Override
	public boolean test(Employee t) {

		return t.getAge() >= 35;
	}

}
