package com.example.crm_crud_product.mapper;

import com.example.crm_crud_product.dto.CategoryDto;
import com.example.crm_crud_product.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category dtoToEntity(CategoryDto categoryDto);
    CategoryDto entityToDto(Category c);
}
