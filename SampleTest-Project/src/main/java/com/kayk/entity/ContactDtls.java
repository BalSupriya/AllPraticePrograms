package com.kayk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Contact_Dtls1")
@NoArgsConstructor
@AllArgsConstructor
public class ContactDtls {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="ContactId")
	private Integer contactId;
	
	@Column(name="ContactName")
	private String contactName;
	
	@Column(name="EmailId")
	private String emailId;
	
	@Column(name="ContactNumber")
	private Long contactNumber;

}
