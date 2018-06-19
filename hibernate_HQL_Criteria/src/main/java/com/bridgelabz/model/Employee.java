package com.bridgelabz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="Employee.byId",query="from Employee where id=?0")
/*@NamedNativeQuery(name="Employee.byName",query="select * from Employee_Details where empName= ?0",resultClass=Employee.class)*/
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="Employee_Details")
public class Employee {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String empName;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}



}
