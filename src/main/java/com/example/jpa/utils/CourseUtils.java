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
import com.example.jpa.repository.ReviewRepository;

@Component
public class CourseUtils {

	private static Logger logger = LoggerFactory.getLogger(CourseUtils.class);
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	private static CourseRepository staticCourseRepository;
	private static ReviewRepository staticReviewRepository;
	
	@PostConstruct     
	private void initStaticDao () {
		staticCourseRepository = this.courseRepository;
		staticReviewRepository = this.reviewRepository;
	}

	@Transactional
	public static Course saveCourseAndReview() {
		logger.info("Begin saveCourseAndReview");
		Course c = staticCourseRepository.findById(10001L);
		Review r = new Review();
		r.setStars("5");
		r.setDescription("Excellent");
		c.addReview(r);
		r.setCourse(c);
		staticCourseRepository.save(c);
		//staticReviewRepository.save(r);
		logger.info("End saveCourseAndReview");
		return c;
	}
	
}
