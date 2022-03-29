package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	TeacherRepository teacherRepository;

	public String save(Teacher teacher) {
		teacherRepository.save(teacher);
		return null;
	}

	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	public Optional<Teacher> findById(Long id) {
		return teacherRepository.findById(id);
	}

	public String updateTeacher(Teacher teacher) {
		Optional<Teacher> existTeacher = teacherRepository.findById(teacher.getId());
		{
			if (existTeacher.isPresent()) {
				Teacher teachData = existTeacher.get();
				teachData.setName(teacher.getName());
				teachData.setEmail(teacher.getEmail());
				teacherRepository.save(teachData);
				return "Teacher Updated...";
			} else {
				return "Teacher not found";
			}
		}
	}

	public String deleteTeacher(Long id) {
		Optional<Teacher> existTeacher = teacherRepository.findById(id);
		if (existTeacher.isPresent()) {
			teacherRepository.deleteById(id);
			return "Teacher deleted";
		} else {
			return "Teacher not found by ID";
		}

	}
}
