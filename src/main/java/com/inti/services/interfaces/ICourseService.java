package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Course;

public interface ICourseService {

	List<Course> findAll();

	Course findOne(Long idCourse);

	Course save(Course course);

	void delete(Long idCourse);
	
	List<Course> findByValidation(boolean validation);

}
