package com.bilichenko.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.bilichenko.model.Category;

public interface CategoryRepository extends Repository<Category, Long> {

	Optional<Category> getById(Long id);

	List<Category> findAll();
}