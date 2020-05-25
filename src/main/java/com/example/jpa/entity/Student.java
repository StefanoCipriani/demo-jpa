package com.example.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"passport", "courses"})
public class Student {

	@Id
	private int id;
	private String name;
	/*
	 * with cascade it will do all operation with child nodes without explicity call crud methods.
	 * In practice if you have a passport associated to a student you don't need to save the passport first 
	 * and then the student.
	 * You can do all in one step, omitting the passport save 
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_PASSAPORTO")
	private Passport passport;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="STUDENT_COURSE",
		joinColumns = @JoinColumn(name = "STUDENT_ID"),
		inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
	)
	private List<Course> courses = new ArrayList<>();
	
	
}
