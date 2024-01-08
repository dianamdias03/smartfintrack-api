package com.api.smartfintrackapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.smartfintrackapi.dtos.CategoryDTO;
import com.api.smartfintrackapi.model.Category;
import com.api.smartfintrackapi.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryDTO convertToDto(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setHasRelatedData(category.getListCashFlow() != null && !category.getListCashFlow().isEmpty());
        return dto;
    }

	public List<CategoryDTO> findAllCategories(Long userLoginId) {
		List<Category> categories = categoryRepository.findByUserLoginId(userLoginId);
		List<CategoryDTO> dtos = new ArrayList<>();
		for (Category cat : categories) {
			dtos.add(convertToDto(cat));
		}
		return dtos;
	}
	
	public CategoryDTO findById(Long id) {
		return convertToDto(categoryRepository.findById(id).orElseThrow());
	}
}
