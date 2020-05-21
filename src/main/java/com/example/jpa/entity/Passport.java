package com.example.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Passport {
	@Id
	private int id;
	private String number;
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
	private Student student;
}
