package com.situ.ssm.entity;

import java.util.ArrayList;
import java.util.List;

public class Banji {
	private Integer id;
	private String name;
	private List<Student> list = new ArrayList<Student>();
	private List<Course> courseList = new ArrayList<Course>();
	
	

	public List<Course> getCoursesList() {
		return courseList;
	}

	public void setCoursesList(List<Course> coursesList) {
		this.courseList = coursesList;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Banji [id=" + id + ", name=" + name + ", list=" + list + ", courseList=" + courseList + "]";
	}

        	

}
