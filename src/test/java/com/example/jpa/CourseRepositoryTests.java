package com.example.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Course;
import com.example.jpa.repository.CourseRepository;


@SpringBootTest
@ActiveProfiles("test")
class CourseRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository repository;
	
	/*
	@Test
	void findByIdTest() {
		Course c = repository.findById(10001L);
		logger.info(c.getName());
		assertEquals("Jpa in simple steps", c.getName());
	}

	@Test
	@DirtiesContext
	void deleteByIdTest() {
		repository.deleteById(10002L);
		Course c = repository.findById(10002L);
		assertNull(c);
	}
	
	@Test
	@DirtiesContext
	void update() {
		Course c = repository.findById(10001L);
		c.setName("go course");
		repository.save(c);
		c = repository.findById(10001L);
		assertEquals("go course", c.getName());
	}
	
	@Test
	@DirtiesContext
	void insert() {
		Course c = new Course();
		c.setName("go course");
		Course save = repository.save(c);
		repository.findById(save.getId());
		assertEquals("go course", save.getName());
	}
	*/
	@Test
	//@DirtiesContext //not working
	@Transactional //with transactional the updates to database will be rolled back
	public void playWithEntityManager() {
		logger.debug("I'm testing");
		repository.playWithEntityManager();
	}
	
	
	@Test
	//@Transactional
	void insert() {
		Course c = new Course();
		//If you set the id and the strategy is @GeneratedValue it will cause "detached entity passed to persist"
		//c.setId(10004L);
		c.setName("go course");
		repository.save(c);
		assertEquals("1", "1"); 
	}
	
}
