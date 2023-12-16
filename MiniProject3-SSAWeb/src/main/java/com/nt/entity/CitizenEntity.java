package com.nt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CITIZEN_DTLS")
public class CitizenEntity {
	
	@Id
	@Column(name="CITIZEN_ID")
	@GeneratedValue
	//@SequenceGenerator
	private Integer citizenId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="GENDER")
	private String gender;

}
