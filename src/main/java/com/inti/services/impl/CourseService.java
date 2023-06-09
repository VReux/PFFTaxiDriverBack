package com.inti.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Course;
import com.inti.repositories.ICourseRepository;
import com.inti.services.interfaces.ICourseService;

@Service
@Transactional
public class CourseService implements ICourseService {
	
	@Autowired
	ICourseRepository courseRepository;

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findOne(Long idCourse) {
		return courseRepository.findById(idCourse).get();
	}

	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public void delete(Long idCourse) {
		courseRepository.deleteById(idCourse);
	}

}
