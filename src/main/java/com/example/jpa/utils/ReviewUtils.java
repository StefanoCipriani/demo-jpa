package com.example.jpa.utils;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Review;
import com.example.jpa.repository.ReviewRepository;

@Component
public class ReviewUtils {

	private static Logger logger = LoggerFactory.getLogger(ReviewUtils.class);
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	private static ReviewRepository staticReviewRepository;
	
	@PostConstruct     
	private void initStaticDao () {
		staticReviewRepository = this.reviewRepository;
	}

	@Transactional
	public static Review saveReviewAndCourse() {
		logger.info("Begin saveReviewAndCourse");
		
		Review r = new Review();
		r.setStars("4");
		r.setDescription("Very Good");
		
		Course c = new Course("Course to be associated to Review");
		Course insertCourse = CourseUtils.insertCourse(c);
		r.setCourse(insertCourse);
		
		staticReviewRepository.save(r);
		logger.info("End saveReviewAndCourse");
		return r;
	}
	
}
