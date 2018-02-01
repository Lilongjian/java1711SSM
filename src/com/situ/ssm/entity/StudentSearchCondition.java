package com.situ.ssm.entity;

public class StudentSearchCondition {
	private Integer pageNo;
	private Integer pageSize;
	private String name;
	private String age;
	private String gender;
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "StudentSearchCondition [pageNo=" + pageNo + ", pageSize=" + pageSize + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	

}
