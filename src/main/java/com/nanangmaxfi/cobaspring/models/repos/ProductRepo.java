package com.nanangmaxfi.cobaspring.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.nanangmaxfi.cobaspring.models.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{

}
