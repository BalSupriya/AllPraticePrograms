package com.nt.controller;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.nt.domain.UserAccount;

import com.nt.service.UserAccountService;


@Controller
public class UserAccountController {
	
	@Autowired
	private UserAccountService userService;
	
	
	
	@RequestMapping(value="/getState")
	@ResponseBody
	public Map<Integer,String> getStateById(@RequestParam("countryId") Integer countryId) {
		return userService.getStateByCountryId(countryId);
		
	}
	
	@RequestMapping(value="/getCity")
	@ResponseBody
	public Map<Integer,String> getCityById(@RequestParam("stateId") Integer stateId) {
		return userService.getCityByStateId(stateId);
		
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public  String loadForm(Model model) {
		model.addAttribute("user", new UserAccount());
		
		
		Map<Integer, String> countries = userService.getAllCountries();
		model.addAttribute("countries", countries);
		
		return "userRegistration";
		
		
	}
	
	@RequestMapping(value="/regUser" ,method=RequestMethod.POST)
	public String saveUserDtls(@ModelAttribute ("user") UserAccount user ,Model model) {
		
		boolean saveUser = userService.saveUser(user);
		
		if(saveUser)
		  model.addAttribute("saveUser"," User Details saved");
		else 
			model.addAttribute("erroruser", "User details doesn't saved");
		System.out.println(saveUser);
		return "regStatus";
		
	}
	
	@RequestMapping(value="/validateEmail") 
	public @ResponseBody String validateEmail(HttpServletRequest req) {
		String email=req.getParameter("email");
	//public @ResponseBody String validateEmail(@RequestParam("email") String email) {
		return userService.validateEmail(email);
			
	}
	
	
	
	@RequestMapping(value="/getUnlock",method=RequestMethod.GET)
	public String getUnlockPage(@RequestParam("email") String email ,Model model) {
		model.addAttribute("email", email);
		return "unlockAccPage";
		
	}
	
	@RequestMapping(value="/getUnlock",method=RequestMethod.POST)
	public @ResponseBody String unlockUserAcc(@RequestParam("tempPwd") String tempPwd,@RequestParam("newPwd") String pwd) {
		System.out.println(tempPwd+"  "+userService.getTempPassword(tempPwd));
		if(tempPwd.equals(userService.getTempPassword(tempPwd))) {
			userService.unlockAcc(pwd, "UNLOCKED");
			return "Account unlocked successfully";
		}
		else {
				return "Something went wrong,pls provide valid credentials";
		}
		
	}
	
	


}
