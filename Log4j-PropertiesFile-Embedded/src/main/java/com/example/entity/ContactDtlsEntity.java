package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="LOGS")
@AllArgsConstructor
@NoArgsConstructor
public class ContactDtlsEntity {
	
	
	@Id
	@Column(name="dated")
	private String date;
	
	@Column(name="THREAD")
	private String thread;
	
	@Column(name="L_NAME")
	private String lineNo;
	
	@Column(name="MSG")
	private String msg;
	

}
