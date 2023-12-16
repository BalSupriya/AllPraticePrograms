package com.nt.utils;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.nt.domain.UserAccount;
import com.nt.entity.UserAccountEntity;;


@Component
public class SendEmail {
	
	@Autowired
    private JavaMailSender javaMailSender;
	

public  boolean  sendEmailForAccUnlock(UserAccount user)  {

   // SimpleMailMessage msg = new SimpleMailMessage();
	try {
	  MimeMessage msg = javaMailSender.createMimeMessage();
      
	    MimeMessageHelper helper = new MimeMessageHelper(msg);
	    
	    helper.setTo(user.getEmail());
	    helper.setSubject("For u");
	   
	helper.setText(readEmailBody(user),true);
	javaMailSender.send(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	     
	  
		
		  //msg.setTo("kush.shraddha.kush@gmail.com");
		/*
		 * msg.setTo(user.getEmail()); msg.setSubject("For u"); try {
		 * msg.setText(readEmailBody(user)); javaMailSender.send(msg); return true; }
		 * catch (IOException e) { e.printStackTrace();
		 * 
		 * 
		 * } return false;
		 */
    

}
//karrasankar@gmail.com

  private String readEmailBody(UserAccount user) throws IOException {
	  
	    String fileMsg="";
	  
	    FileReader file=new FileReader("SEND-EMAIL-UNLOCK-ACC.txt");

	     BufferedReader br = new BufferedReader(file);
	     fileMsg=br.readLine();
	     StringBuffer sb=new  StringBuffer();
	     while (fileMsg != null) {
	    	 sb.append(fileMsg);
	    	 fileMsg = br.readLine();
	     }
	    	    //System.out.println(fileMsg); 
	     String string = sb.toString();
	     string=string.replace("<FNAME>", user.getFirstName());
	     string=string.replace("<LNAME>", user.getLastName());
		 string=string.replace("<TEMP-PASS>", user.getPazzword()); 
		 string=string.replace("<email>", user.getEmail()); 
	     
	return string;
	  
  }
  
  
  public  boolean  sendEmailForPwd(UserAccount user)  {

	   // SimpleMailMessage msg = new SimpleMailMessage();
		try {
		  MimeMessage msg = javaMailSender.createMimeMessage();
	      
		    MimeMessageHelper helper = new MimeMessageHelper(msg);
		    
		    helper.setTo(user.getEmail());
		    helper.setSubject("Forgot pwd");
		   
		helper.setText(readEmailBody02(user),true);
		javaMailSender.send(msg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		     
  }
  
  
  private String readEmailBody02(UserAccount user) throws IOException {
	  
	    String fileMsg="";
	  
	    FileReader file=new FileReader("SEND-PWD.txt");

	     BufferedReader br = new BufferedReader(file);
	     fileMsg=br.readLine();
	     StringBuffer sb=new  StringBuffer();
	     while (fileMsg != null) {
	    	 sb.append(fileMsg);
	    	 fileMsg = br.readLine();
	     }
	    	    //System.out.println(fileMsg); 
	     String string = sb.toString();
	     string=string.replace("<FNAME>", user.getFirstName());
	     string=string.replace("<LNAME>", user.getLastName());
		 string=string.replace("<PWD>", user.getPazzword()); 
		 //string=string.replace("<email>", user.getEmail()); 
	     
	return string;
	  
}

}
