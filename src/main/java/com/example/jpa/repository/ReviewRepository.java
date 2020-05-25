package com.example.jpa.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Review;

@Repository
@Transactional
public class ReviewRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private EntityManager em;
	
	public Review findById(Long id) {
		return em.find(Review.class,id);
	}
	
	public void deleteById(Long id) {
		Review c = findById(id);
		if(c != null)
			em.remove(c);
	}
	
	public Review save(Review review) {
		em.persist(review);
		return review;
	}
	
	
}
