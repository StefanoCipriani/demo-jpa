package com.example.jpa.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Passport;

@Repository
@Transactional
public class PassportRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private EntityManager em;
	
	
	public Passport retrieve() {
		Passport passport = em.find(Passport.class, 1);
		return passport;
	}
	
}
