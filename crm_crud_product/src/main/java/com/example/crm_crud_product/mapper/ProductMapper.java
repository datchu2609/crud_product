package com.example.crm_crud_product.mapper;

import com.example.crm_crud_product.dto.ProductDto;
import com.example.crm_crud_product.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product dtoToEntity(ProductDto productDto);
    ProductDto entityToDto(Product c);
}
