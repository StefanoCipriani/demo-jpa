package com.example.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private EntityManager em;
	
	public void save(Student student){
		logger.debug("Saving Student -> {}", student);
		/*
		 * if no cascade are setted on passport field of student class, we must save passport manually
		 * 
		*/
		//em.persist(student.getPassport()); 
		em.persist(student);
	}
	
	public Student retrieve() {
		Student student = em.find(Student.class, 1);
		return student;
	}
	
	public Student getOne() {
		List<Student> resultList = em.createQuery("SELECT s from Student s", Student.class).getResultList();
		return resultList != null && resultList.size() > 0 ? resultList.get(0): null ;
	}
	
	public Student findById(int id) {
		return em.find(Student.class, id);
	}
	
}
