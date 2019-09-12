package com.sheikh.nfvis4j.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Sheikh Qumruzzaman
 * Sep 9, 2019
 */
@JsonRootName("employees")
public class Employees implements Serializable{
	@JsonProperty("employee")
	List<Employee> employees;
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	private static class Employee implements Serializable{
		private String name;
		private String title;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	}
}
