package com.nt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.UserAccountEntity;

public interface UserAccountRepo  extends JpaRepository<UserAccountEntity, Integer>{

	public UserAccountEntity findByEmail(String email);
	
	public UserAccountEntity findByPazzword(String pwd);
	
	@Modifying
	@Transactional
	@Query(value="update UserAccountEntity set pazzword=:pwd,status=:accStatus")
	public void unlockAcc(String pwd,String accStatus);
	
	public UserAccountEntity findByEmailAndPazzword(String email,String Pazzword);
	
	
	
}
