package com.example.crm_crud_product.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;

    @PrePersist
    private void beforeInsert(){
        this.setCreateAt(LocalDateTime.now());
    }
    @PreUpdate
    private void beforeUpdate(){
        this.setUpdateAt(LocalDateTime.now());
    }
}
