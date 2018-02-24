package com.situ.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.ssm.entity.Banji;
import com.situ.ssm.entity.BanjiSearchCondition;
import com.situ.ssm.entity.Student;

public interface BanjiDao {
	public Banji findBanjiInfoById(Integer id);
	public List<Student> findStudentByName(String banjiName);
	public Banji findClassCourseInfoByName(String banjiName);
	public List<Banji> findAll();
	public int getTotalCountByCondition(BanjiSearchCondition condition);
	public List<Banji> findPageBeanListByCondition(@Param(value="condition")BanjiSearchCondition condition, @Param(value="offset")int offset);

}
