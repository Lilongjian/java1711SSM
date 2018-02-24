package com.situ.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.ssm.entity.Student;
import com.situ.ssm.entity.StudentSearchCondition;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.vo.PageBean;

@Controller
@RequestMapping(value="/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    
    @RequestMapping(value="/list")
    /*@ResponseBody*/
    public List<Student> list(){
    	List<Student> list = studentService.findAll();
    	for (Student student : list) {
			System.out.println(student);
		}
    	return list;
    }
    @RequestMapping(value="/findById")
    public ModelAndView findById(){
    	System.out.println("StudentController.findById()");
    	ModelAndView modelAndView = new ModelAndView();
    	int id = 182;
    	Student student = studentService.findById(id);
    	modelAndView.addObject("student", student);
    	System.out.println(student);
    	return modelAndView;
    }
    
    @RequestMapping(value="/findByName")
    public void findByName(){
       System.out.println("StudentController.findByName()");
       String tableName="student";
       String name = "李隆";
       
       List<Student> students = studentService.findByName(tableName,name);
       System.out.println(students);
    }
    
    @RequestMapping(value="/getPage")
    public ModelAndView getPage(){
    	System.out.println("StudentController.getPage()");
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("student_add");
    	return modelAndView;
    }
    @RequestMapping(value="/add")
    public ModelAndView add(Student student){
    	System.out.println(student);
    	int count = studentService.add(student);
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("redirect:/student/searchByCondition");
    	return modelAndView;
    }
    
    //学生搜索加分页
    @RequestMapping(value="/searchByCondition")
    public String searchByCondition(StudentSearchCondition condition,Model model){
    	System.out.println(condition);
    	if (condition.getPageNo() == null || "".equals(condition.getPageNo())) {
			condition.setPageNo(1);
		}
    	if (condition.getPageSize() == null || "".equals(condition.getPageSize())) {
			condition.setPageSize(5);
		}
    	PageBean<Student> pageBean = studentService.searchByCondition(condition);
    	model.addAttribute("pageBean", pageBean);
    	model.addAttribute("searchCondition", condition);
    	return "student_list";
    	
    }
    //批量删除
    @RequestMapping(value="/deleteAll")
    public ModelAndView delete(int[] checkedIds){
    	System.out.println(Arrays.toString(checkedIds));
    	int count = studentService.deleteAll(checkedIds);
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("redirect:/student/searchByCondition");
    	return modelAndView;
    }
    //通过id删除学生
	@RequestMapping(value="/delete")
	public String deleteById(int id,Model model){
		System.out.println(id);
		System.out.println("瘪犊子" + id);
		studentService.deleteById(id);
		return "redirect:/student/searchByCondition";
	}
	//修改学生信息（1）
		@RequestMapping(value="/toUpdate")
		public String toupdate(int id,Model model){
			System.out.println(id);
			Student student = studentService.findById(id);
			model.addAttribute("student", student);
			return "student_edit";
		}
		//修改学生信息（2）
		@RequestMapping(value="/update")
		public String Update(Student student) throws UnsupportedEncodingException{
			System.out.println(student);
			studentService.update(student);
			return "redirect:/student/searchByCondition.action";
		}
    
    
    
}
