
  package com.example;
  
  import static org.junit.Assert.assertNotNull;


import org.easymock.EasyMock;
import org.junit.Test;
import
  org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.ContactDao;
import com.example.exception.ContactException;
import com.example.service.ContactServiceImpl;
  
  @SpringBootTest 
  class MockingTestApplicationTests {
  
  
  @Test void contextLoads() { }
  
  
  
  @Test(expected = ContactException.class)
	public void testGetContactByName01() {
		ContactServiceImpl service=new ContactServiceImpl();
		//create mock object for dao interface
		
		ContactDao dao = EasyMock.createMock(ContactDao.class);
		
		//injecting mock dao into service
		service.setDao(dao);
		
		//service method call
		Long phno = service.fetchCNumByName("supriya");
		assertNotNull(phno);
		
		
	}
  
  @Test(expected = ContactException.class)
	public void testGetContactByName02() {
		ContactServiceImpl service=new ContactServiceImpl();
		//create mock object for dao interface
		
		ContactDao dao = EasyMock.createMock(ContactDao.class);
		
		EasyMock.expect(dao.findCNumByCName("supi")).andReturn(12334566l);
		EasyMock.replay(dao);
		
		//injecting mock dao into service
		service.setDao(dao);
		
		//service method call
		Long phno = service.fetchCNumByName("supi");
		assertNotNull(phno);
		
		
	}
  }
 
