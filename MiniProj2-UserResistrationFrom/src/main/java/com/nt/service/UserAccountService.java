package com.nt.service;

import java.util.Map;

import com.nt.domain.UserAccount;

public interface UserAccountService {
	
	public boolean saveUser(UserAccount user);
	
	public Map<Integer,String> getAllCountries();
	
	public Map<Integer,String> getStateByCountryId(Integer countryId);
	
	public Map<Integer,String> getCityByStateId(Integer stateId);
	
	public String validateEmail(String email);
	
	public String getTempPassword(String pwd);
	
	public boolean unlockAcc(String pwd,String accStatus);
	
	
	public String getEmailAndPassword(String email,String pazzword);
	
	public String sendEmailForPwd(UserAccount user);

}
