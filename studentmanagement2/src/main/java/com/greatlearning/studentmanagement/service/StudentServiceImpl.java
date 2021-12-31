package com.greatlearning.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentmanagement.entity.Student;
import com.greatlearning.studentmanagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteById(long studentId) {
		studentRepository.deleteById(studentId);

	}

	@Override
	public Student findById(long studentId) {
		Optional<Student> optionalStudent = studentRepository.findById(studentId);
		Student student = optionalStudent.get();
		return student;
	}

}
