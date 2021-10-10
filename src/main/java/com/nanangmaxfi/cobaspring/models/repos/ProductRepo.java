package com.nanangmaxfi.cobaspring.models.repos;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nanangmaxfi.cobaspring.models.entities.Product;
import com.nanangmaxfi.cobaspring.models.entities.Supplier;

public interface ProductRepo extends CrudRepository<Product, Long>{

	//List<Product> findByNameContains(String name);
	
	@Query("SELECT p FROM Product p WHERE p.name = :name")
	public Product findProductByName(@PathParam("name") String name);
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE :name")
	public List<Product> findProductByNameLike(@PathParam("name") String name);
	
	@Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
	public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);
	
	@Query("SELECT p FROM Product p WHERE :supplier MEMBER OF p.suppliers")
	public List<Product> findProductBySupplier(@PathParam("supplier") Supplier supplier);
}
