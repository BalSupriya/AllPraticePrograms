package com.nt.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CitizenAddressDtls {
	
	private Integer citizenAddrId;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String city;

}
