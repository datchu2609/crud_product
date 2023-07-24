package com.example.crm_crud_product.controller;

import com.example.crm_crud_product.dto.ProductDto;
import com.example.crm_crud_product.manager.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class ProductController {
    @Autowired
    private ProductManager productManager;

    @GetMapping("/products")
    public ResponseEntity<?> gets() {
        return ResponseEntity.ok(productManager.gets());
    }

    @PostMapping("/product/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto product) {
//        log.info("process=create-product, product={}", product);
        return ResponseEntity.ok(productManager.save(product));
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
//        log.info("process=update-product, product_id={}", id);
        return ResponseEntity.ok(productManager.delete(id));
    }
}
