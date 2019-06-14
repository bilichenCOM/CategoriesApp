package com.bilichenko.jdbc_dao;

import java.util.List;
import java.util.Optional;

import com.bilichenko.model.Category;

public interface GenericDao<T, ID> {

	Optional<T> getById(ID id);

	Optional<List<T>> getAll();

	Optional<Category> update(T t);

	void delete(T t);

	Optional<Category> save(T t);
}