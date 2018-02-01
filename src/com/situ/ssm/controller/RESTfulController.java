package com.situ.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.ssm.entity.Student;
import com.situ.ssm.service.IStudentService;

@Controller
public class RESTfulController {
	@Autowired
	private IStudentService studentService;
	
	//GET   /students 返回所有学生列表
	@RequestMapping(value="/students",method=RequestMethod.GET)
	@ResponseBody
	public List<Student> list(){
		List<Student> list = studentService.findAll();
		return list;
	}
	
	//GET   /students/129 返回学号为129的学生
	@RequestMapping(value="/students/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Student findById(@PathVariable("id")Integer id){
		Student student = studentService.findById(id);
		return student;
		
	}
	
	//delete /students/129 删除id为129的学生
	@RequestMapping(value="/students/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public int  deleteById(@PathVariable("id")Integer id){
		int count = studentService.deleteById(id);
		return count;
	}
	

}
