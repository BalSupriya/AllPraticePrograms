package com.kayk.service;

import java.util.List;
import java.util.Optional;

import com.kayk.entity.ContactDtls;


public interface ContactDtlsService {
	
	public Boolean saveContact(ContactDtls contact);
	public List<ContactDtls> findAllContact();
	public void deleteContact(Integer contactId);
	public ContactDtls findById(Integer contactId);

}
