package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	@PostMapping
	public String add(@RequestBody Teacher teacher) {
		return teacherService.save(teacher);
	}
	@GetMapping
	public List<Teacher>getTeacher(){
		return teacherService.findAll();
	}
	@GetMapping("/{id}")
	public Optional<Teacher>getById(@PathVariable Long id){
		return teacherService.findById(id);
	}
	@PutMapping("/{id}")
	public String updateTeacher(@RequestBody Teacher teacher,@PathVariable Long id) {
		teacher.setId(id);
		return teacherService.updateTeacher(teacher);
	}
	@DeleteMapping("/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		return teacherService.deleteTeacher(id);
	}
	

}
