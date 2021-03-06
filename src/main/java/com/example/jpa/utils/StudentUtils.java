package com.example.jpa.utils;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Passport;
import com.example.jpa.entity.Student;
import com.example.jpa.repository.StudentRepository;

@Component
public class StudentUtils {

	private static Logger logger = LoggerFactory.getLogger(StudentUtils.class);

	
	@Autowired
	private StudentRepository studentRepository;

	private static StudentRepository staticStudentRepository;

	@PostConstruct     
	private void initStaticDao () {
		staticStudentRepository = this.studentRepository;
	}

	@Transactional
	public static void saveStudentWithPassport() {
		Student s = new Student();
		s.setId(1);
		s.setName("Guastolfo");
		Passport p = new Passport();
		p.setId(1);
		p.setNumber("XXXXX");
		s.setPassport(p);
		staticStudentRepository.save(s);

	}
	
	
	@Transactional
	public static Student retrieveStudentAndPassportDetails() {
		Student student = staticStudentRepository.retrieve();
		logger.info("Student retrieved -> {}", student);
		logger.debug("Passport retreived -> {}", student.getPassport());
		return student;
	}
	
	@Transactional
	public static void retrieveStudentAndCourses() {
		logger.info("BEGIN retrieveStudentAndCourses");
		Student student = staticStudentRepository.getOne();
		logger.info("Student: {}", student);
		logger.info("Courses: {}",student.getCourses());
		logger.info("END retrieveStudentAndCourses");
	}
	
	@Transactional
	public static void insertStudentAndCourse(Student s, Course c){
		logger.info("BEGIN insertStudentAndCourse");
		s.getCourses().add(c);
		staticStudentRepository.save(s);
		logger.info("END insertStudentAndCourse");
	}
	
}
