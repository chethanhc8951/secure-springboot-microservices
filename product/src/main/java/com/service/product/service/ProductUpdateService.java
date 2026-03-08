package com.service.product.service;

import com.service.product.model.Product;
import jakarta.validation.Valid;

public interface ProductUpdateService {
    Product updateProduct(Long id, @Valid Product product);
}
