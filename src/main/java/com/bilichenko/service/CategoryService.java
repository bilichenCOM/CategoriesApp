package com.bilichenko.service;

import java.util.List;
import java.util.Optional;

import com.bilichenko.model.Category;

public interface CategoryService {

	Optional<Category> create(Category category);

	Optional<List<Category>> getAll();

	Optional<Optional<Category>> getById(Long id);
}