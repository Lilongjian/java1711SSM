
package com.situ.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.ssm.entity.Student;
import com.situ.ssm.entity.StudentSearchCondition;

public interface StudentDao {

	List<Student> findAll(String column);

	Student findById(int id);

	List<Student> findByName(@Param("tableName")String tableName, @Param("name")String name);

	int add(Student student);

	int getTotalCountByCondition(StudentSearchCondition condition);

	/*List<Student> findPageBeanListByCondition(@Param(value="condition")StudentSearchCondition condition, @Param(value="offset")int offset);*/
    
	List<Student> findPageBeanListByCondition(StudentSearchCondition condition);
	int deleteById(Integer id);

	int deleteAll(int[] checkedIds);

	void update(Student student);

}
