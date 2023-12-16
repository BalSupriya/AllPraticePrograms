package com.example.dao;

import java.util.List;

import com.example.model.Contact;

public interface ContactDao {
	
	public Long findCNumByCName(String name);
	public List<Contact> findAll();

}
