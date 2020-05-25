package com.example.jpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Student;
import com.example.jpa.utils.CourseUtils;
import com.example.jpa.utils.GeneralUtils;
import com.example.jpa.utils.PassportUtils;
import com.example.jpa.utils.ReviewUtils;
import com.example.jpa.utils.StudentUtils;

@Service
public class StartOperationService {

	//private static Logger logger = LoggerFactory.getLogger(StartOperationService.class);

	
	@Transactional
	public void executeStudentMethods() {
		StudentUtils.saveStudentWithPassport();
		StudentUtils.retrieveStudentAndPassportDetails();
		Student student = new Student();
		student.setName("Stefano");
		Course course = new Course("Kubernates");
		StudentUtils.insertStudentAndCourse(student,course);
		
		StudentUtils.retrieveStudentAndCourses();
	}
	
	@Transactional
	public void executePassportMethods() {
		PassportUtils.retrievePassportAndRelatedStudentDetails();
	}
	
	@Transactional
	public void executeCourseMethods() {
		CourseUtils.saveCourseAndReview();
		CourseUtils.retrieveCoursesAndStudent();
		CourseUtils.jplCourseWithoutStudents();
		CourseUtils.deleteCourse();
	}
	
	@Transactional
	public void executeReviewMethods() {
		ReviewUtils.saveReviewAndCourse();
	}
	
	@Transactional
	public void executeGeneralMethods() {
		GeneralUtils.jpqlStudentJoinCourses();
	}
	
	@Transactional
	public void executeAll(){
		executeStudentMethods();
		executePassportMethods();
		executeCourseMethods();
		executeReviewMethods();
		executeGeneralMethods();
	}
}
