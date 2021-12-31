package com.greatlearning.studentmanagement.service;

import java.util.List;

import com.greatlearning.studentmanagement.entity.Student;

public interface StudentService {
	public List<Student> findAll();

	public void save(Student student);

	public void deleteById(long studentId);

	public Student findById(long studentId);
}
