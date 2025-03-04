package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.CourseRepository;
import com.app.entities.Course;

@Service
public class CourseService {

	@Autowired private CourseRepository repo;
	
	public void saveCourse(Course comp) {
		repo.save(comp);
	}
	
	public List<Course> listall(){
		return repo.findAll();
	}
	
	public void deleteCourse(int id) {
		repo.delete(repo.getById(id));
	}
	
	public Course findById(int id) {
		return repo.getById(id);
	}
}
