package com.example.service;

import java.util.List;

import com.example.dao.ContactDao;
import com.example.exception.ContactException;
import com.example.model.Contact;

public class ContactServiceImpl implements ContactService {
	
	private ContactDao dao;

	public void setDao(ContactDao dao) {
		this.dao = dao;
	}

	@Override
	public Long fetchCNumByName(String name) {
		Long Phno = dao.findCNumByCName(name);
		if(Phno==null) {
			throw new ContactException("Invalid name") ;
		}
		
		return Phno;
	}

	@Override
	public List<Contact> fetchAll() {
		
		List<Contact> findall = dao.findAll();
		
		if(findall.isEmpty()) {
			throw new ContactException("Data not found");
		}
		return findall;
	}

}
