package com.example.jpa.utils;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Review;
import com.example.jpa.repository.CourseRepository;

@Component
public class CourseUtils {

	private static Logger logger = LoggerFactory.getLogger(CourseUtils.class);
	
	@Autowired
	private CourseRepository courseRepository;

	private static CourseRepository staticCourseRepository;
	
	@PostConstruct     
	private void initStaticDao () {
		staticCourseRepository = this.courseRepository;
	}

	@Transactional
	public static Course saveCourseAndReview() {
		//Save a course and a review (starting by course)
		logger.info("Begin saveCourseAndReview");
		Course c = staticCourseRepository.findById(10001L);
		Review r = new Review();
		r.setStars("5");
		r.setDescription("Excellent");
		c.addReview(r);
		r.setCourse(c);
		staticCourseRepository.save(c);
		logger.info("End saveCourseAndReview");
		return c;
	}
	
	@Transactional
	public static Course insertCourse(Course c) {
		Course course = staticCourseRepository.save(c);
		return course;
	}
	
	@Transactional
	public static void retrieveCoursesAndStudent() {
		logger.info("BEGIN retrieveCoursesAndStudent");
		Course course = staticCourseRepository.findById(10001L);
		logger.info("Course: {}", course);
		logger.info("Students: {}",course.getStudents());
		logger.info("END retrieveCoursesAndStudent");
	}
	
	@Transactional
	public static void deleteCourse() {
		//Delete a course cause deleting child entities also
		//logger.info("Begin saveCourseAndReview");
		//staticCourseRepository.deleteById(10001L);
	}
	
	@Transactional
	public static void jplCourseWithoutStudents() {
		logger.info("BEGIN JplCourseWithoutStudents");
		logger.info("RESULTS -> {}",staticCourseRepository.courseWithoutStudent());
		logger.info("BEGIN JplCourseWithoutStudents");
	}
	
}
