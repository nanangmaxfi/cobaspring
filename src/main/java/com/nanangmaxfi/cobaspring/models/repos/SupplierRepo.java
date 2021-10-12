package com.nanangmaxfi.cobaspring.models.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nanangmaxfi.cobaspring.models.entities.Supplier;

public interface SupplierRepo extends CrudRepository<Supplier, Long>{
	
	Supplier findByEmail(String email);
	
	List<Supplier> findByNameContains(String name);
	
	List<Supplier> findByNameStartingWith(String prefix);
}
