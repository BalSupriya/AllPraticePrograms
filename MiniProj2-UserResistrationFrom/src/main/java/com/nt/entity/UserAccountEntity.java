package com.nt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="USER_ACCOUNT")
public class UserAccountEntity {
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue
	private Integer userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="PASSWORD")
	private String pazzword;
	
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
    @Column(name="CURRENT_DATE" ,updatable = false)
    private Date currentDate;
	
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	@Column(name="UPDATE_DATE",insertable = false)
    private Date updateDate;


}
