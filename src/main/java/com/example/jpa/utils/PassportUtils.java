package com.example.jpa.utils;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Passport;
import com.example.jpa.repository.PassportRepository;

@Component
public class PassportUtils {

	private static Logger logger = LoggerFactory.getLogger(PassportUtils.class);

	
	@Autowired
	private PassportRepository passportRepository;

	private static PassportRepository staticPassportRepository;

	@PostConstruct     
	private void initStaticDao () {
		staticPassportRepository = this.passportRepository;
	}

	
	
	@Transactional
	public static Passport retrievePassportAndRelatedStudentDetails() {
		Passport passport = staticPassportRepository.retrieve();
		logger.info("Passport retrieved -> {}", passport);
		logger.info("Student retrieved -> {}", passport.getStudent());
		return passport;
	}
}
