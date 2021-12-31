package com.greatlearning.studentmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("Students", students);
		return "liststudents";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "studentform";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
		// Optional<Student> student = new Student();
		Student student = studentService.findById(id);
		model.addAttribute("Student", student);
		return "studentform";

	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String fName,
			@RequestParam("lastName") String lName, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		System.out.println(id);
		Student student;

		if (id != 0) {
			student = studentService.findById(id);
			student.setFirstName(fName);
			student.setLastName(lName);
			student.setCourse(course);
			student.setCountry(country);
		} else {
			student = new Student(fName, lName, course, country);

		}
		studentService.save(student);
		return "redirect:/student/list";

	}

	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id) {
		studentService.deleteById(id);
		return "redirect:/student/list";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Sorry" + user.getName() + "!! , you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
