package com.example.crm_crud_product.mapper;

import com.example.crm_crud_product.dto.UnitDto;
import com.example.crm_crud_product.entity.Unit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnitMapper {
    Unit dtoToEntity(UnitDto unitDto);
    UnitDto entityToDto(Unit c);
}
