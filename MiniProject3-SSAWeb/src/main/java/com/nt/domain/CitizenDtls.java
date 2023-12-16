package com.nt.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CitizenDtls {
	
	private Integer citizenId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;

}
