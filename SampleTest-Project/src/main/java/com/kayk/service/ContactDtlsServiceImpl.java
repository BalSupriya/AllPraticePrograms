package com.kayk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayk.Repository.contactDtlsRepo;
import com.kayk.entity.ContactDtls;

@Service
public class ContactDtlsServiceImpl implements ContactDtlsService {
	
	@Autowired
	private contactDtlsRepo contactRepo;

	@Override
	public Boolean saveContact(ContactDtls contact) {
		ContactDtls save = contactRepo.save(contact);
		
		
		return save.getContactId() != null ? true : false ;
	}

	@Override
	public List<ContactDtls> findAllContact() {
	List<ContactDtls> findAll = contactRepo.findAll();
	if(findAll != null) {
		return findAll ;
	}
		return null;
	}

	@Override
	public void deleteContact(Integer contactId) {
		// TODO Auto-generated method stub
		 contactRepo.deleteById(contactId);
		
		
		 
	}

	@Override
	public  ContactDtls findById(Integer contactId) {
		// TODO Auto-generated method stub
		Optional<ContactDtls> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
		    return findById.get();
		}
		
		return null;
	
		

	
		
	}



}
