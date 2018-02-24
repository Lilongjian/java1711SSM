package com.situ.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.ssm.dao.StudentDao;
import com.situ.ssm.entity.Student;
import com.situ.ssm.entity.StudentSearchCondition;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.vo.PageBean;
@Service
public class StudentServiceImpl implements IStudentService{
	@Autowired
	private StudentDao studentDao;
	

	@Override
	public List<Student> findAll() {
		return studentDao.findAll(null);
	}


	@Override
	public Student findById(int id) {
		return studentDao.findById(id);
	}


	@Override
	public List<Student> findByName(String tableName,String name) {
		return studentDao.findByName(tableName,name);
	}


	@Override
	public int add(Student student) {
		int count = studentDao.add(student);
		return count ;
	}


	@Override
	public PageBean<Student> searchByCondition(StudentSearchCondition condition) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setPageNo(condition.getPageNo());
		pageBean.setPageSzie(condition.getPageSize());
		int totalCount = studentDao.getTotalCountByCondition(condition);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil((double)totalCount / condition.getPageSize());
		pageBean.setTotalPage( totalPage);
		/*int offset = (condition.getPageNo() - 1) * (condition.getPageSize());*/
		/*List<Student> list = studentDao.findPageBeanListByCondition(condition,offset);*/
		List<Student> list = studentDao.findPageBeanListByCondition(condition);
		pageBean.setList(list);
		return pageBean;
	}


	@Override
	public int deleteById(Integer id) {
		return studentDao.deleteById(id);
	}


	@Override
	public int deleteAll(int[] checkedIds) {
		return studentDao.deleteAll(checkedIds);
	}


	@Override
	public void update(Student student) {
		studentDao.update(student);
		
	}

}
