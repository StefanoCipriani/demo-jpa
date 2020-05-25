package com.example.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class,id);
	}
	
	public void deleteById(Long id) {
		Course c = findById(id);
		if(c != null)
			em.remove(c);
	}
	
	public Course save(Course course) {
		if(course.getId() == null){
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
	}
	
	public void playWithEntityManager() {
		logger.debug("playWithEntityManager - start");
		Course course = new Course("Web services in 100 steps");
		em.persist(course);
		course.setName("Web services in 100 steps - Updated");
		logger.debug("playWithEntityManager - end");
	}
	
	public List<Course> courseWithoutStudent (){
		TypedQuery<Course> createQuery = em.createQuery("SELECT c from Course c where c.students is empty", Course.class);
		return createQuery.getResultList();
	}
	
}
