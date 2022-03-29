package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public String save(Student student) {
		studentRepository.save(student);
		return null;
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}

	public String updateStudent(Student student) {
		Optional<Student> existStudent = studentRepository.findById(student.getId());
		if (existStudent.isPresent()) {
			Student stud = existStudent.get();
			stud.setName(student.getName());
			stud.setRoll_no(student.getRoll_no());
			stud.setDob(student.getDob());
			stud.setMob(student.getMob());
			stud.setEmail(student.getEmail());
			studentRepository.save(stud);
			return "Student Name Updated..";
		} else {
			return "Student does not exist";
		}

	}

	public String deleteStudent(Long id) {
		Optional<Student> student=studentRepository.findById(id);
		if(student.isPresent()) {
		 studentRepository.deleteById(id);
		 return "Student Deleted...";
	}else
		return "Student not exist";
}
}