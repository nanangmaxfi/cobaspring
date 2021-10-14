package com.nanangmaxfi.cobaspring.models.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nanangmaxfi.cobaspring.models.entities.Category;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Long>{

	Page<Category> findByNameContains(String name, Pageable pageable);
}
