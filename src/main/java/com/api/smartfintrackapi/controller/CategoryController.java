package com.api.smartfintrackapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.smartfintrackapi.dtos.CategoryDTO;
import com.api.smartfintrackapi.model.Category;
import com.api.smartfintrackapi.repository.CategoryRepository;
import com.api.smartfintrackapi.service.CategoryService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired 
	CategoryService categoryService;
	
	@GetMapping("/categories/{userLoginId}")
	public List<CategoryDTO> listCategory(@PathVariable Long userLoginId){
		return categoryService.findAllCategories(userLoginId);
	}
	
	@GetMapping("/category/{id}/{userLoginId}")
	public Optional<Category> listCategoryUnic(@PathVariable(value="id") long id){
		return categoryRepository.findById(id);
	}
	
	@PostMapping("/category")
	public Category saveCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}
	
	@PostMapping("/categories")
	public List<Category> saveCategories(@RequestBody List<Category> categories) {
		return categoryRepository.saveAll(categories);
	}
	
	@DeleteMapping("/categories")
	public void deleteCategories(@RequestBody List<Long> data) {
		categoryRepository.deleteAllById(data);
	}
}
