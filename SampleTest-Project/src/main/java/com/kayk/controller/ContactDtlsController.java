package com.kayk.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kayk.entity.ContactDtls;
import com.kayk.service.ContactDtlsService;

@RestController
@RequestMapping("/contact")
public class ContactDtlsController {
	
	//Logger logger = LoggerFactory.getLogger(ContactDtlsController.class);

	
	@Autowired
	private ContactDtlsService contactService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveContact(@RequestBody ContactDtls contact) {
		Boolean saveContact = contactService.saveContact(contact);
		
		
			
			return new ResponseEntity<>("contact saved", HttpStatus.OK);	
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ContactDtls>> findAllContact(){
		List<ContactDtls> allContact = contactService.findAllContact();
		return new ResponseEntity<> (allContact,HttpStatus.OK) ;
		
		
	}
	
	@DeleteMapping("/{contactId}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer contactId) {
	contactService.deleteContact(contactId);
			
	return new ResponseEntity<>("contact deleted", HttpStatus.OK);	
	}
	
	
	
	
	@SuppressWarnings("unused")
	@GetMapping("/{contactId}")
	public ResponseEntity<ContactDtls> findContactById(@PathVariable Integer contactId) {

		ContactDtls findById = contactService.findById(contactId);
		
		
		/*  if (findById == null) { 
			  throw new NoDataFoundException("No contact found");
		  
		  }*/
		 
		 if(findById  != null) {
		     return new ResponseEntity<>(findById, HttpStatus.OK);
		 }
		return new ResponseEntity<>(findById, HttpStatus.BAD_REQUEST);
		 
		 
	}
	
	

}
