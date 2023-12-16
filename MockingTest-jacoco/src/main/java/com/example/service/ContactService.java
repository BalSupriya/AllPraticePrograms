package com.example.service;

import java.util.List;

import com.example.model.Contact;

public interface ContactService {
	
	public Long fetchCNumByName(String name);
	public List<Contact> fetchAll();

}
