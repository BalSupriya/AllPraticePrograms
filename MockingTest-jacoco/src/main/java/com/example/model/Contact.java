package com.example.model;

public class Contact {

	
	private Integer contactId;
	private String contactName;
	private Long contactNum;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(Integer contactId, String contactName, Long contactNum) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactNum = contactNum;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Long getContactNum() {
		return contactNum;
	}

	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactNum=" + contactNum + "]";
	}
	
	




	
}
