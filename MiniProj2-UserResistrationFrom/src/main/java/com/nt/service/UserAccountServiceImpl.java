package com.nt.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.omg.CORBA.UserException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.domain.UserAccount;
import com.nt.entity.CityMasterEntity;
import com.nt.entity.CountryMasterEntity;
import com.nt.entity.StateMasterEntity;
import com.nt.entity.UserAccountEntity;
import com.nt.repository.CityMasterRepo;
import com.nt.repository.CountryMasterRepo;
import com.nt.repository.StateMasterRepo;
import com.nt.repository.UserAccountRepo;
import com.nt.utils.RandomPass;
import com.nt.utils.SendEmail;

@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountRepo userRepo;
  
	@Autowired
	 private CountryMasterRepo countryRepo;
	
	@Autowired
	private StateMasterRepo stateRepo;
	
	@Autowired
	private CityMasterRepo cityRepo;
	
	@Autowired
	private SendEmail sendEmail;
	
	@Override
	public boolean saveUser(UserAccount user) {
		
		user.setStatus("Locked");
		user.setPazzword(RandomPass.randomAlphaNumeric(5));
		
		UserAccountEntity userEntity=new UserAccountEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		//userEntity.setPazzword(RandomPass.randomAlphaNumeric(6));
		
		UserAccountEntity saveUser = userRepo.save(userEntity);
		
		if(saveUser.getUserId()!=null)
		
				return sendEmail.sendEmailForAccUnlock(user);
			
		else
			return false;
	
	}

	


	@Override
	public String validateEmail(String email) {
		   
		   UserAccountEntity findByEmail = userRepo.findByEmail(email);
		   if(findByEmail != null) {
			   return "DUPLICATE";
		   }
		   
		
		return "UNIQUE";
	}
	
	@Override
	public Map<Integer, String> getAllCountries() {
		
		Map<Integer,String> cmap=new LinkedHashMap<Integer, String>();
	
		List<CountryMasterEntity> findAllcountry = countryRepo.findAll();
		
		findAllcountry.forEach(country ->{
			cmap.put(country.getCountryId(),country.getCountryName());
			
		});
		return cmap;
	}




	@Override
	public Map<Integer, String> getStateByCountryId(Integer countryId) {
		
		Map<Integer,String> smap=new LinkedHashMap<Integer, String>();
       List<StateMasterEntity> findStateByCountryId = stateRepo.findAllByCountryId(countryId);
       findStateByCountryId.forEach(state ->{
    	   smap.put(state.getStateId(), state.getStateName());
    	   
       });
       
		
		return smap;
	}




	@Override
	public Map<Integer, String> getCityByStateId(Integer stateId) {
		
		Map<Integer,String> ctmap=new LinkedHashMap<Integer, String>();
		List<CityMasterEntity> findCityByStateId = cityRepo.findAllByStateId(stateId);
		
		findCityByStateId.forEach(city ->{
	    	   ctmap.put(city.getCityId(),city.getCityName());
	    	   
	       });
		return ctmap;
	}




	@Override
	public String getTempPassword(String pwd) {
		UserAccountEntity entity = userRepo.findByPazzword(pwd);
		
		  UserAccount user=new UserAccount(); 
		  BeanUtils.copyProperties(entity, user);
		 System.out.println(user.getEmail());
		 
		return entity.getPazzword();
		
		
	}




	@Override
	public boolean unlockAcc(String pwd, String accStatus) {
		userRepo.unlockAcc(pwd, accStatus);
		return true;
	}
	
	
	@Override
	public String getEmailAndPassword(String email, String pazzword) {
		UserAccountEntity entity = userRepo.findByEmailAndPazzword(email, pazzword);
		
		if(entity!=null) {
			if(entity.getStatus().equals("UNLOCKED")) {
				
				return "SUCCESS";
			}
			else {
				return "LOCKED";
			}
		}
		else
			
		return "INVALID";
	}
	
	
	@Override
	public String sendEmailForPwd(UserAccount user) {
	
		
		UserAccountEntity entity = userRepo.findByEmail(user.getEmail());
		
		BeanUtils.copyProperties(entity, user);
		
		if(user.getUserId()!=null) {
			boolean sendEmailForPwd = sendEmail.sendEmailForPwd(user);
			return "success";
			
		}
		
		return "invalid";
	}

}
