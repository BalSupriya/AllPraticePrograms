package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Citizen_Addrs_dtls")
public class CitizenAddressEntity {
	
	@Id
	@GeneratedValue
	@Column(name="CITIZEN_ADDRS_ID")
	private Integer citizenAddrId;
	
	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="CITY")
	private String city;
	

}
