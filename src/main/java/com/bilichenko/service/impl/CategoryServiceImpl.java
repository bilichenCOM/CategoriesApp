package com.bilichenko.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bilichenko.dao.CategoryRepository;
import com.bilichenko.model.Category;
import com.bilichenko.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public Optional<List<Category>> getAll() {
		return Optional.of(categoryRepository.findAll());
	}


	@Override
	public Optional<Category> create(Category category) {
		return null;
	}


	@Override
	public Optional<Optional<Category>> getById(Long id) {
		return null;
	}
}