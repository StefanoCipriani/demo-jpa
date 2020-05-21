package com.example.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.jpa.entity.Course;

@SpringBootTest
@ActiveProfiles("test")
class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager em;
	
	@Test
	void jpql() {
		logger.info("JPQL-test");
		TypedQuery<Course> courses = em.createQuery("select c from Course c", Course.class);
		logger.debug("Courses -> {}",courses.getResultList());
	}

}
