package com.nt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.domain.UserAccount;
import com.nt.service.UserAccountService;

@Controller
public class LoginController {
	
	@Autowired
	private UserAccountService userService;
	
	@RequestMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String getLoginPage(HttpServletRequest req,Model model) {
		
		String email=req.getParameter("email");
		String pazzword=req.getParameter("pwd");
		
		String string = userService.getEmailAndPassword(email, pazzword);
		
		if(string.equals("SUCCESS")) {
			model.addAttribute("success", "userLogin Success");
		}
		else if(string.equals("LOCKED")) {
			
			model.addAttribute("locked", "User Login Locked");
		}
		else
		model.addAttribute("invalid", "Invalid user");
		
		return "loginStatus";
	}
	
	
	@RequestMapping(value="/forgot" ,method=RequestMethod.GET)
	public String saveUserDtls(UserAccount user) {
		
	
		
		String forPwd = userService.sendEmailForPwd(user);
		
		
		
		return "forgotPwd";
		}
		

}
