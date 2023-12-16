package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ContactDtlsEntity;

public interface LogRepo extends JpaRepository<ContactDtlsEntity, Integer> {

}
