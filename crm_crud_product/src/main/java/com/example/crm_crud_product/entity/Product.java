package com.example.crm_crud_product.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    private String code;
    private Long weight;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id",referencedColumnName = "id")
    private Unit unit;
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

    @PrePersist
    private void beforeInsert(){
        this.setCreateAt(LocalDateTime.now());
    }
    @PreUpdate
    private void beforeUpdate(){
        this.setUpdateAt(LocalDateTime.now());
    }

}