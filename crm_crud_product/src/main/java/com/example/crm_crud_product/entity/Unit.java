package com.example.crm_crud_product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "unit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Unit extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "name")
    private String name;
    @JoinColumn(name = "code")
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
