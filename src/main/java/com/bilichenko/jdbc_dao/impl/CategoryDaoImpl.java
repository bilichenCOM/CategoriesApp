package com.bilichenko.jdbc_dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bilichenko.jdbc_dao.CategoryDao;
import com.bilichenko.jdbc_dao.templates.CategoryDaoJdbcTemplate;
import com.bilichenko.model.Category;

//@Repository("categoryDao1")
public class CategoryDaoImpl implements CategoryDao {

//	@Autowired
	private CategoryDaoJdbcTemplate template;

	@Override
	public Optional<Category> getById(Long id) {
		return template.getById(id);
	}

	@Override
	public Optional<List<Category>> getAll() {
		return template.getAll();
	}

	@Override
	public Optional<Category> update(Category t) {
		return template.update(t);
	}

	@Override
	public void delete(Category t) {
	}

	@Override
	public Optional<Category> save(Category t) {
		return template.create(t);
	}
}
