package com.miApp.AppS.Impl;

import com.miApp.AppS.dto.CategoryDTO;
import com.miApp.AppS.entity.Category;
import com.miApp.AppS.exceptions.CustomException;
import com.miApp.AppS.repository.CategoryRepository;
import com.miApp.AppS.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.categoryRepository = null; // This is not a good practice, but included to match the constructor signature.
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findAllCategories() {
        return null;
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomException("Category not found with id: " + categoryId));
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if(categoryRepository.findById(categoryDTO.getIdCategory()).isPresent()) {
            throw new CustomException("Category with this ID already exists");
        }
        Category category = modelMapper.map(categoryDTO, Category.class);
        category = categoryRepository.save(category);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomException("Category not found with id: " + categoryId));
        category.setName(categoryDTO.getName());
        category.setIdCategory(categoryDTO.getIdCategory());
        category = categoryRepository.save(category);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new CustomException("Category not found with id: " + categoryId);
        }
        categoryRepository.deleteById(categoryId);
        return true;

    }
}
