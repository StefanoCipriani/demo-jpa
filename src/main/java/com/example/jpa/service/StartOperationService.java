package com.example.jpa.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Review;
import com.example.jpa.utils.CourseUtils;
import com.example.jpa.utils.PassportUtils;
import com.example.jpa.utils.StudentUtils;

@Service
public class StartOperationService {

	private static Logger logger = LoggerFactory.getLogger(StartOperationService.class);

	
	@Transactional
	public void executeStudentMethods() {
		StudentUtils.saveStudentWithPassport();
		StudentUtils.retrieveStudentAndPassportDetails();
	}
	
	@Transactional
	public void executePassportMethods() {
		PassportUtils.retrievePassportAndRelatedStudentDetails();
	}
	
	@Transactional
	public void executeCourseMethods() {
		logger.info("This will save a course with a review");
		Course c = CourseUtils.saveCourseAndReview();
		logger.info("Course ->{}", c);
		Set<Review> reviews = c.getReviews();
		logger.info("Reviews -> {}", reviews.size());
	}
}
