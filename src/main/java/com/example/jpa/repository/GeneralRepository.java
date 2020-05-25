package com.example.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Course;

@Repository
public class GeneralRepository {

	private static Logger logger = LoggerFactory.getLogger(GeneralRepository.class);

	@Autowired
	private EntityManager em;
	
	public void jpqlStudentJoinCourses() {
		logger.info("BEGIN jpqlStudentJoinCourses");
		List<?> resultList = em.createQuery("SELECT c,s from Course c JOIN c.students s").getResultList();
		logger.info("Reuslt -> {}", resultList);
		logger.info("END jpqlStudentJoinCourses");
	}
	
	public void criteriaQuery() {
		logger.info("BEGIN criteriaQuery");
		// 1. Use Criteria Builder to create a Criteria Query returning the expected result object
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		//2. Define roots for tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);
		//3. Define predicates etc using Criteria Builder
		//4. Add predicates etc to the Criteria Query
		//5. Build the TypedQuery using the entity manager and  criteria query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Typed Query -> {}", resultList);
		logger.info("END criteriaQuery");
	}
}
