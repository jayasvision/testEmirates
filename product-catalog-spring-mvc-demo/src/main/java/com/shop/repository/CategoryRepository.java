package com.shop.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

/*
 * Repository Layer is responsible for retrievel of data
 */
@Repository
public interface CategoryRepository {
	
	public List<String> findAll();
	
}
