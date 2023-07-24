package com.example.crm_crud_product.manager;

import com.example.crm_crud_product.dto.ProductDto;
import com.example.crm_crud_product.entity.Product;
import com.example.crm_crud_product.mapper.ProductMapper;
import com.example.crm_crud_product.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Slf4j
@Service
//@Transactional("tenantTransactionManager")
public class ProductManager {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductMapper mapper;

    public List<ProductDto> gets() {
        List<ProductDto> productDtos = repository.findAll().stream().map(mapper::entityToDto).collect(Collectors.toList());
        return productDtos;
    }

    public ProductDto save(ProductDto productDto) {
        Product product = Optional.ofNullable(productDto).map(mapper::dtoToEntity).orElse(null);
        if (product != null) {
            return Optional.ofNullable(repository.save(product)).map(mapper::entityToDto).orElse(null);
        } else {
            return null;
        }
    }

    public ProductDto delete(Long id) {
        Optional<Product> productOptional = repository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setIsDeleted((byte) 1);
            if (product != null) {
                return Optional.ofNullable(repository.save(product)).map(mapper::entityToDto).orElse(null);
            } else {
                return null;
            }
        }
        return null;
    }

}
