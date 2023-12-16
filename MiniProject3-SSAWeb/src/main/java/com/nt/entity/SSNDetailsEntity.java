package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="SSN_DETAILS")
public class SSNDetailsEntity {
	
	@Id
	@Column(name="ZZN_ID")
	@GeneratedValue
	private Integer zznId;
	
	@Column(name="ZZN_NO")
	private Long zznNo;
	
	@Column(name="CITIZEN_ID")
	private Integer citizenId;

}
