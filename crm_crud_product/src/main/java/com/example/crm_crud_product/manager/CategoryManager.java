package com.example.crm_crud_product.manager;

import com.example.crm_crud_product.dto.CategoryDto;
import com.example.crm_crud_product.entity.Category;
import com.example.crm_crud_product.mapper.CategoryMapper;
import com.example.crm_crud_product.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryManager {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private CategoryMapper mapper;

    public List<CategoryDto> gets() {
        List<CategoryDto> categoryDtos = repository.findAll().stream().map(mapper::entityToDto).collect(Collectors.toList());
        return categoryDtos;
    }

    public CategoryDto save(CategoryDto categoryDto) {
        Category category = Optional.ofNullable(categoryDto).map(mapper::dtoToEntity).orElse(null);
        if (category != null) {
            return Optional.ofNullable(repository.save(category)).map(mapper::entityToDto).orElse(null);
        } else {
            return null;
        }
    }

    public CategoryDto delete(Long id) {
        Optional<Category> categoryOptional = repository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setIsDeleted((byte) 1);
            if (category != null) {
                return Optional.ofNullable(repository.save(category)).map(mapper::entityToDto).orElse(null);
            } else {
                return null;
            }
        }
        return null;
    }
}
