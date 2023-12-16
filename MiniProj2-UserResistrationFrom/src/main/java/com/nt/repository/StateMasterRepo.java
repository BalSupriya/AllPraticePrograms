package com.nt.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.StateMasterEntity;

public interface StateMasterRepo extends JpaRepository<StateMasterEntity, Integer> {

	public List<StateMasterEntity> findAllByCountryId(Integer countryId);
	
}
