package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByValidation(boolean validation);

}
