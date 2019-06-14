package com.bilichenko.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bilichenko.model.Category;
import com.bilichenko.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public ModelAndView getAll(ModelAndView mav) {
		List<Category> categories = categoryService.getAll()
				.orElseGet(() -> Collections.emptyList());
		mav.addObject("categories", categories);
		mav.setViewName("categories");
		return mav;
	}

	@GetMapping("/add-category")
	public ModelAndView create(ModelAndView mav) {
		mav.addObject("category", new Category());
		mav.setViewName("add-category");
		return mav;
	}

	@PostMapping("/add-category")
	public ModelAndView create(@ModelAttribute Category category, ModelAndView mav) {
		categoryService.create(category);
		List<Category> categories = categoryService.getAll()
				.orElseGet(() -> Collections.emptyList());
		mav.addObject("categories", categories);
		mav.setViewName("categories");
		return mav;
	}

	@GetMapping("/edit-category")
	public ModelAndView edit(@RequestParam("c_id") Long id, ModelAndView mav) {
		mav.addObject("category", categoryService.getById(id));
		mav.setViewName("edit-category");
		return mav;
	}

	@PostMapping("/edit-category")
	public ModelAndView edit(@ModelAttribute Category category, ModelAndView mav) {
//		TODO implement udpate method
//		categoryService.update(category);
		List<Category> categories = categoryService.getAll()
				.orElseGet(() -> Collections.emptyList());
		mav.addObject("categories", categories);
		mav.setViewName("categories");
		return mav;
	}
}