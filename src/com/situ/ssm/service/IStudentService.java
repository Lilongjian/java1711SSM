package com.situ.ssm.service;

import java.util.List;

import com.situ.ssm.entity.Student;
import com.situ.ssm.entity.StudentSearchCondition;
import com.situ.ssm.vo.PageBean;

public interface IStudentService {

	List<Student> findAll();

	Student findById(int id);

	List<Student> findByName(String tableName, String name);

	int add(Student student);

	PageBean<Student> searchByCondition(StudentSearchCondition condition);

	int deleteById(Integer id);

}
