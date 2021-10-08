package com.nanangmaxfi.cobaspring.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.nanangmaxfi.cobaspring.models.entities.Category;

public interface CategoryRepo extends CrudRepository<Category, Long>{

}
