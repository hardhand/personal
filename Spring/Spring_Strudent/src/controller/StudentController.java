package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Student;
import service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping ("studentList.do")
	public ModelAndView studentList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("studentList", service.studentList());
		mav.setViewName("studentList");
		return mav;
	}
	
	@RequestMapping("addStudentForm.do")
	public void addStudentForm() {
		
	}
	
	@RequestMapping("addStudent.do")
	public String addStudent(String id, String name, String grade) {
		Student student = new Student();
		student.setId(Integer.parseInt(id));
		student.setName(name);
		student.setGrade(grade);
		service.insertStudent(student);
		return "redirect:main.do";
		
	}
	
	@RequestMapping("deleteStudent.do")
	public void deleteStudent(int id) {
		service.deleteStudent (id);
		
	}
	
	@RequestMapping("modifyStudentForm.do")
	public String modifyStudentForm(int id, Model model) {
		model.addAttribute("student", service.getStudent(id));
		return "modifyStudentForm";
	}
	
	@RequestMapping("modifyStudent.do")
	public String modifyStudent(Student student) {
		service.updateStudent(student);
		return "redirect:main.do";
	}
	
	@RequestMapping("main.do")
	public void main() {
		
	}

}
