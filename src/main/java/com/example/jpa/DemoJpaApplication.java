package com.example.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Course;
import com.example.jpa.repository.CourseRepository;
import com.example.jpa.service.StartOperationService;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository repository;
	
	@Autowired
	private StartOperationService opService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Course course = repository.findById(10001L);
		logger.info("Course 10001 is -> {}", course);
		//repository.playWithEntityManager();
		opService.executeStudentMethods();
		opService.executePassportMethods();
	}

	
}
