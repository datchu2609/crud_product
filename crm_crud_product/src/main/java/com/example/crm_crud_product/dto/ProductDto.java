package com.example.crm_crud_product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private Long id;
    private String name;
    private CategoryDto category;
    private String code;
    private Long weight;
    private UnitDto unit;
    private byte status;
    private BigDecimal priceInStock;
    private BigDecimal priceOutStock;
    private String barCode;
    private Double vat;
    private BigDecimal priceWithoutVat;
    private Long width;
    private Long height;
    private Long length;
    private byte isProperties;
    private String properties;
    private LocalDateTime createAt;
    private String createBy;
    private LocalDateTime updateAt;
    private String updateBy;
    private byte isDeleted;
}
