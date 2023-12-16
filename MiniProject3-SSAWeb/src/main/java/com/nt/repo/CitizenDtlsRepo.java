package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CitizenAddressEntity;

public interface CitizenDtlsRepo extends JpaRepository<CitizenAddressEntity, Integer> {

}
