package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Course;
import com.inti.services.interfaces.ICourseService;

@RestController
@CrossOrigin
public class CourseController {

	@Autowired
	ICourseService courseService;

	@GetMapping("/courses")
	public List<Course> findAll() {
		return courseService.findAll();
	}

	@GetMapping("/courses/{idCourse}")
	public Course findOne(@PathVariable("idCourse") Long idCourse) {
		return courseService.findOne(idCourse);
	}
	
	@GetMapping("/courses/validation/{validation}")
	   public List<Course> findByValidation(@PathVariable("validation") boolean validation) {
	       return courseService.findByValidation(validation);
	   }


	@PostMapping("courses")
	public Course saveCourse(@RequestBody Course course) {
		return courseService.save(course);
	}

	@DeleteMapping("courses/{idCourse}")
	public void deleteCourse(@PathVariable("idCourse") Long idCourse) {
		courseService.delete(idCourse);
	}

	@PutMapping("courses/{idCourse}")
	public Course updateCourse(@PathVariable("idCourse") Long idCourse, @RequestBody Course course) {
		Course currentCourse = courseService.findOne(idCourse);
		currentCourse.setIdCourse(course.getIdCourse());
		currentCourse.setAvisCourse(course.getAvisCourse());
		currentCourse.setNoteCourse(course.getNoteCourse());
		currentCourse.setNoteChauffeur(course.getNoteChauffeur());
		currentCourse.setTempsCourse(course.getTempsCourse());
		currentCourse.setPrixReel(course.getPrixReel());
		currentCourse.setDepart(course.getDepart());
		currentCourse.setArrivee(course.getArrivee());
		currentCourse.setDistancekm(course.getDistancekm());
		currentCourse.setValidation(course.isValidation());
		return courseService.save(currentCourse);
	}

}
