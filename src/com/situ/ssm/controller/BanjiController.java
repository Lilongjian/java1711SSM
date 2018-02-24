package com.situ.ssm.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.ssm.entity.Banji;
import com.situ.ssm.entity.BanjiSearchCondition;
import com.situ.ssm.entity.Student;
import com.situ.ssm.service.IBanjiService;
import com.situ.ssm.service.IStudentService;
import com.situ.ssm.vo.PageBean;

import net.sf.json.JSONArray;

@Controller
@RequestMapping(value="/banji")
public class BanjiController extends HttpServlet{
	@Autowired
	private IBanjiService banjiService;
	private IStudentService studentService;
	
	//获得学生添加界面
	@RequestMapping(value="/getPage")
	public ModelAndView getPage(){
		System.out.println("BanjiController.getPage()");
		List<Banji> list = banjiService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("student_add");
		return modelAndView;
	}
	
	//查询所有学生
	@RequestMapping(value="/findAll")
	public ModelAndView findAll(){
		System.out.println("StudentController.findAll()");
		List<Student> list = studentService.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("student_list");
		return modelAndView;
	}
	
	//添加学生
	@RequestMapping(value="/add")
	 public ModelAndView add(Student student) {
        System.out.println("学生");
        System.out.println(student);
        studentService.add(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", student);
        modelAndView.setViewName("forward:/student/findAll.action");
        return modelAndView;
	 }
        
      //通过id删除学生
	@RequestMapping(value="/delete")
	public String deleteById(int id,Model model){
		System.out.println(id);
		System.out.println("瘪犊子" + id);
		studentService.deleteById(id);
		return "forward:/banji/findAll.action";
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
		return "redirect:/student/findAll.action";
	}
	
	//班级表搜索加分页
	@RequestMapping(value="/searchByCondition")
	public String searchByCondition(BanjiSearchCondition condition,Model model){
		System.out.println(condition);
		//Integer pageNo = condition.getPageNo();
		if (condition.getPageNo() == null || "".equals(condition.getPageNo())) {
			condition.setPageNo(1);
		}
		if (condition.getPageSize() == null || "".equals(condition.getPageSize())) {
			condition.setPageSize(5);
		}
		PageBean<Banji> pageBean = banjiService.searchByCondition(condition);
		System.out.println(pageBean);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("searchCondition", condition);
		System.out.println(pageBean);
		return "banji_list";
	}
	
	
	@RequestMapping(value="/banjiServlet")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		    System.out.println("BanjiController.doPost()");
		    List<Banji> list = banjiService.findAll();
		    JSONArray jsonArray = JSONArray.fromObject(list);
	        System.out.println(jsonArray.toString());
			resp.setContentType("text/html;charset=utf-8");
			resp.getWriter().write(jsonArray.toString());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	

}
