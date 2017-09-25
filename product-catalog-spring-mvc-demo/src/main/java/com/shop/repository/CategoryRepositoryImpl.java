package com.shop.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepositoryImpl implements CategoryRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;


	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAll() {
		return mongoTemplate.getCollection("products").distinct("categories");
	}
	
	
}
