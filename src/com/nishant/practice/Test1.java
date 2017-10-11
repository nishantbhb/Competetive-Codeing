package com.nishant.practice;

import java.util.HashSet;
import java.util.Set;

class Employee {
	private Integer id;
	private String firstname;
	private String lastName;
	private String department;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o == this) {
			return true;
		}
		if (getClass() != o.getClass()) {
			return false;
		}

		Employee e = (Employee) o;
		return (this.getId() == e.getId());

	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + getId();
		System.out.println(result);
		return result;
	}
}

public class Test1 {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();

		e1.setId(100);
		e2.setId(100);

		// Prints 'true'
		System.out.println(e1.equals(e2));

		Set<Employee> employees = new HashSet<Employee>();
		employees.add(e1);
		employees.add(e2);

		// Prints two objects
		System.out.println(employees);
	}

}
