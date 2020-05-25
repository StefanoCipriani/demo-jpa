package com.example.jpa.utils;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jpa.repository.GeneralRepository;

@Component
public class GeneralUtils {

	private static Logger logger = LoggerFactory.getLogger(GeneralUtils.class);
	
	@Autowired
	private GeneralRepository generalRepository;

	private static GeneralRepository staticGeneralRepository;
	
	@PostConstruct     
	private void initStaticDao () {
		staticGeneralRepository = this.generalRepository;
	}
	
	public static void jpqlStudentJoinCourses() {
		staticGeneralRepository.jpqlStudentJoinCourses();
	}
	
}
