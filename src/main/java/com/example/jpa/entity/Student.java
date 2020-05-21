package com.example.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "passport")
public class Student {

	@Id
	private int id;
	private String name;
	/*
	 * with cascade it will do all operation with child nodes without explicity call crud methods.
	 * In practice if you have a passport associated to a student you don't need to save the passport first 
	 * and then the student.
	 * You can do all in one step, omitting the passport save
	 * */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)// 
	//@OneToOne
	@JoinColumn(name="ID_PASSAPORTO")
	private Passport passport;
}
