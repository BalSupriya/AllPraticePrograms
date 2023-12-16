package com.nt.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CityMasterEntity;

public interface CityMasterRepo extends JpaRepository<CityMasterEntity, Integer> {

	
	public List<CityMasterEntity> findAllByStateId(Integer stateId);
}
