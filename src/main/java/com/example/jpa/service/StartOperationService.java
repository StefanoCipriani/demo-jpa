package com.example.jpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.utils.PassportUtils;
import com.example.jpa.utils.StudentUtils;

@Service
public class StartOperationService {

	@Transactional
	public void executeStudentMethods() {
		StudentUtils.saveStudentWithPassport();
		StudentUtils.retrieveStudentAndPassportDetails();
	}
	
	@Transactional
	public void executePassportMethods() {
		PassportUtils.retrievePassportAndRelatedStudentDetails();
	}
	
}
