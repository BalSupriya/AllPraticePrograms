package com.kayk.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kayk.entity.ContactDtls;


@Repository
public interface contactDtlsRepo extends JpaRepository<ContactDtls, Serializable>{

}
